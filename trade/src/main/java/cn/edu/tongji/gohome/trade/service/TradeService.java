package
        cn.edu.tongji.gohome.trade.service;

import cn.edu.tongji.gohome.trade.dto.OrderInfoDto;
import cn.edu.tongji.gohome.trade.utils.RedisUtils;
import org.springframework.stereotype.Service;

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
}