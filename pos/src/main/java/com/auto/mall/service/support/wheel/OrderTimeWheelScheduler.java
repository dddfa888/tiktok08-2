package com.auto.mall.service.support.wheel;

import cn.hutool.core.collection.CollectionUtil;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import io.netty.util.internal.PlatformDependent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OrderTimeWheelScheduler implements TimeWheelScheduler {
    private final HashedWheelTimer executorService = new HashedWheelTimer();
    private final ScheduledThreadPoolExecutor scheduledExecutor = new ScheduledThreadPoolExecutor(2);
    private final ConcurrentMap<String, List<Timeout>> scheduledFutures = PlatformDependent.newConcurrentHashMap();
    private final ConcurrentMap<String, Integer> scheduledStatus = PlatformDependent.newConcurrentHashMap();
    private static volatile OrderTimeWheelScheduler ORDER_WHEEL_TIMER;

    public static OrderTimeWheelScheduler getInstance() {
        if (null == ORDER_WHEEL_TIMER) {
            synchronized (OrderTimeWheelScheduler.class) {
                if (null == ORDER_WHEEL_TIMER) {
                    ORDER_WHEEL_TIMER = new OrderTimeWheelScheduler();
                }
            }
        }
        return ORDER_WHEEL_TIMER;
    }

    private OrderTimeWheelScheduler() {}

    public void schedule(String key, Runnable runnable, long delay, TimeUnit unit) {
        Timeout timeout = this.executorService.newTimeout(new OrderTimeWheelScheduler$1(this, runnable) , delay, unit);
        if (!timeout.isExpired()) {
            this.put(key, timeout);
        }
    }

    private void put(String key, Timeout timeout) {
        List<Timeout> timeoutList = this.scheduledFutures.get(key);
        if (CollectionUtil.isEmpty(timeoutList)) {
            timeoutList = new ArrayList<>();
        }
        timeoutList.add(timeout);
        this.scheduledFutures.put(key, timeoutList);
    }

    public void cancel(String key) {
        List<Timeout> timeouts = this.scheduledFutures.get(key);
        if (CollectionUtil.isNotEmpty(timeouts)) {
            Iterator<Timeout> iterator = timeouts.iterator();
            while (iterator.hasNext()) {
                Timeout timeout = iterator.next();
                if (timeout != null && !timeout.isExpired()) {
                    timeout.cancel();  // Cancel the timeout if it's still active
                }
            }
        }
    }

    public void shutdown() {
        // 停止 HashedWheelTimer，并等待所有任务完成或取消
        executorService.stop();

        // 关闭 ScheduledThreadPoolExecutor
        scheduledExecutor.shutdown();
        try {
            if (!scheduledExecutor.awaitTermination(1, TimeUnit.MINUTES)) {
                scheduledExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledExecutor.shutdownNow();
            Thread.currentThread().interrupt();  // 恢复中断状态
        }
    }

    class OrderTimeWheelScheduler$1 implements TimerTask {
        private final Runnable runnable;
        private final OrderTimeWheelScheduler this$0;

        OrderTimeWheelScheduler$1(final OrderTimeWheelScheduler this$0, final Runnable runnable) {
            this.this$0 = this$0;
            this.runnable = runnable;
        }

        @Override
        public void run(Timeout timeout) throws Exception {
            this$0.scheduledExecutor.execute(runnable);
        }
    }
}
