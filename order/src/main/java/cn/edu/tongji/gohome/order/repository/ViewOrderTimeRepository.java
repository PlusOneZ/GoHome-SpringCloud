package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.ViewOrderTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewOrderTimeRepository extends JpaRepository<ViewOrderTimeEntity,Long> {
    ViewOrderTimeEntity findFirstByOrderId(long orderId);
}
