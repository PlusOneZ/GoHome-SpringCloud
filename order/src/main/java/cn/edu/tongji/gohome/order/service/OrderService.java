package cn.edu.tongji.gohome.order.service;

import cn.edu.tongji.gohome.order.dto.FootMapInfoDto;
import cn.edu.tongji.gohome.order.dto.OrderContent;
import cn.edu.tongji.gohome.order.model.ViewCouponInformationEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface OrderService {

    HashMap<String, Object> searchOrderInfoForCustomerId(long customerId, Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchOrderInfoForCustomerIdAndOrderStatus(long customerId, int orderStatus, Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchOrderInfoForHost(long customerId, Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchOrderInfoForHostAndOrderStatus(long customerId, int orderStatus, Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchOrderDetailedInfoForOrderId(long orderId, Integer currentPage, Integer pageSize);

    Long addOrderAndDetailedInformation(OrderContent orderContent);

    void updateOrderStatus(long orderId, int orderStatus);

    Map<String,Object> searchUsableCouponForCustomerId(long customerId, BigDecimal couponLimit, Integer currentPage, Integer pageSize);

    void updateOCouponStatus(long couponId, int couponStatus);

    List<FootMapInfoDto> getFootMapInformation(long customerId);
}
