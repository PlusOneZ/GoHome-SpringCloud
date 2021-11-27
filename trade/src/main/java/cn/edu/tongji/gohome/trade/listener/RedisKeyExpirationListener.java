package
        cn.edu.tongji.gohome.trade.listener;

import cn.edu.tongji.gohome.trade.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * use the redis listener to implement control the order expiration...
 *
 * @author : loey
 * @className : RedisKeyExpirationListener
 * @since : 2021-11-26 09:23
 **/

@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    @Resource
    private RedisUtils redisUtils;

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {

        // get the order id to deal with the Timeout situation...
        long orderId = Long.parseLong(message.toString());
        System.out.println("该订单已经超时支付取消, 订单Id为: " + orderId);
        if(redisUtils.exists(String.valueOf(orderId))){

            System.out.println("the order in redis, orderId: "+orderId);
            redisUtils.remove(String.valueOf(orderId));

            //use order service to remove the order with order id = orderId;

        }
    }
}