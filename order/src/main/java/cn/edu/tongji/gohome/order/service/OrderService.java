package cn.edu.tongji.gohome.order.service;

import cn.edu.tongji.gohome.order.dto.OrderContent;
import cn.edu.tongji.gohome.order.model.ViewCouponInformationEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
public interface OrderService {

    HashMap<String, Object> searchOrderInfoForCustomerId(long customerId, Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchOrderInfoForStayId(long stayId, Integer currentPage, Integer pageSize);

    HashMap<String, Object> searchOrderDetailedInfoForOrderId(long orderId, Integer currentPage, Integer pageSize);

    Long addOrderAndDetailedInformation(OrderContent orderContent);

    void updateOrderStatus(long orderId, int orderStatus);

    List<ViewCouponInformationEntity> searchUsableCouponForCustomerId(long customerId, BigDecimal couponLimit, Integer currentPage, Integer pageSize);

    void updateOCouponStatus(long couponId, int couponStatus);
}
