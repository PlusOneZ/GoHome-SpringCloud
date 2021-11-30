package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.OrderReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReportRepository extends JpaRepository<OrderReportEntity, Long> {
    OrderReportEntity findByOrderId(long orderId);
}
