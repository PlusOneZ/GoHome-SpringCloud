package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.OrderStayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderStayRepository类的DAO
 * @author 梁乔
 * @date 2021/11/23 16:55 
 */
public interface OrderStayRepository extends JpaRepository<OrderStayEntity, Long> {
    OrderStayEntity findByOrderId(Long orderId);
}