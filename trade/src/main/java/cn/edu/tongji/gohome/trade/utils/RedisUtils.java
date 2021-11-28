package
        cn.edu.tongji.gohome.trade.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * class description
 *
 * @author : loey
 * @className : RedisUtils
 * @since : 2021-11-26 11:21
 **/

@Service
public class RedisUtils {
    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(final String key, Object value, Long expireTime, TimeUnit timeUnit){
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }


}