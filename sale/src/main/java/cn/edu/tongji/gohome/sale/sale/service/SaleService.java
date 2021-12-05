package cn.edu.tongji.gohome.sale.sale.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;

/**
 * 有关礼券微服务的业务逻辑接口类
 * @author 梁乔
 * @since 2021/11/24 22:14 
 */
@Service
public interface SaleService {
    HashMap<String, Object> getRoomPriceInfo(String stayId, int roomId, String startDate, String endDate, String couponId) throws ParseException;

    HashMap<String,Object> getCouponInfoByCustomerId(long customerId);

    void useCouponByCouponId(long couponId);

    void addCouponType(BigDecimal couponAmount, BigDecimal couponLimit, String couponName);

    void deleteCouponType(int couponId);
}