package
        cn.edu.tongji.gohome.trade.service;

import cn.edu.tongji.gohome.trade.dto.OrderInfoDto;
import cn.edu.tongji.gohome.trade.dto.OrderStatus;
import cn.edu.tongji.gohome.trade.utils.RedisUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * class description
 *
 * @author : loey
 * @className : TradeService
 * @since : 2021-11-26 13:54
 **/
@Service
public class TradeService {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private RestTemplate restTemplate;

    public void insertOrderInRedis(Long orderId, OrderInfoDto orderInfoDto){
        boolean hasKey = redisUtils.exists(String.valueOf(orderId));
        if(hasKey){
            System.out.println("Redis has store the order.");
        }
        else{
            System.out.println("insert order into the redis");
            redisUtils.set(String.valueOf(orderId),orderInfoDto,15L, TimeUnit.MINUTES);
            System.out.println("order has insert successfully !!");
        }
    }

    public void cancelOrder(long orderId){
        System.out.println("该订单已经超时支付取消, 订单Id为: " + orderId);
        System.out.println("the order in redis, orderId: " + orderId);
        System.out.println("订单在redis中删除完成");
        if (redisUtils.exists(String.valueOf(orderId))){
            redisUtils.remove(String.valueOf(orderId));
        }
        //use order service to remove the order with order id = orderId;
        restTemplate.delete("http://order-service/api/v1/order?orderId={1}", orderId);
        System.out.println("订单在数据库中删除完成");
    }

    public void completePaymentForOrder(long orderId){
        System.out.println("该订单已经完成，经过支付宝回调后修改订单状态与删除Redis内的订单");
        boolean hasKey = redisUtils.exists(String.valueOf(orderId));
        restTemplate.put("http://order-service/api/v1/order/status?orderId={1}&orderStatus={2}",String.class,orderId,OrderStatus.ORDER_PAYMENT_COMPLETED);
        if(hasKey){
            redisUtils.remove(String.valueOf(orderId));
        }
    }
}