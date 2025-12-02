 

package com.auto.mall.service.support.wheel;

import java.util.concurrent.TimeUnit;

public interface TimeWheelScheduler {
    void schedule(String key, Runnable runnable, long delay, TimeUnit unit);

    void cancel(String key);
}
