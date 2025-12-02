 

package com.auto.mall.service.redis;

import cn.hutool.core.collection.CollectionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Component;

@Component
public class RedisService {
    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);
    @Resource
    RedissonClient redisson;
    static volatile ConfigurableConversionService conversionService = (ConfigurableConversionService)ApplicationConversionService.getSharedInstance();

    public RedisService() {
    }

    public boolean tryLock(String key) {
        RLock lock = this.redisson.getLock(key);

        try {
            if (null != lock) {
                return lock.tryLock(3L, 60L, TimeUnit.SECONDS);
            }
        } catch (InterruptedException var4) {
            InterruptedException ex = var4;
            ex.printStackTrace();
        }

        return false;
    }

    public boolean unLock(String key) {
        RLock lock = this.redisson.getLock(key);

        try {
            lock.unlock();
            return true;
        } catch (Exception var4) {
            Exception ex = var4;
            ex.printStackTrace();
            return false;
        }
    }

    public <V> V get(String key, Class<V> targetType) {
        RBucket<V> bucket = this.redisson.getBucket(key);
        return this.convertValueIfNecessary(bucket.get(), targetType);
    }

    public <V> V get(String key, Class<V> targetType, Codec codec) {
        RBucket<V> bucket = this.redisson.getBucket(key, codec);
        return this.convertValueIfNecessary(bucket.get(), targetType);
    }

    public <V> List<V> getList(String key, Class<V> targetType, Codec codec) {
        List<V> result = new ArrayList();
        RList<Object> list = this.redisson.getList(key, codec);
        if (CollectionUtil.isNotEmpty(list)) {
            Iterator var6 = list.iterator();

            while(var6.hasNext()) {
                Object o = var6.next();
                result.add(this.convertValueIfNecessary(o, targetType));
            }
        }

        return result;
    }

    public <V> void set(String key, V value) {
        RBucket<V> bucket = this.redisson.getBucket(key);
        bucket.set(value);
    }

    public <V> void set(String key, V value, Codec codec) {
        RBucket<V> bucket = this.redisson.getBucket(key, codec);
        bucket.set(value);
    }

    private <V> V convertValueIfNecessary(Object value, Class<V> targetType) {
        return targetType != null ? conversionService.convert(value, targetType) : null;
    }
}
