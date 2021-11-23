package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.OrderStayEntity;
import cn.edu.tongji.gohome.order.model.OrderStayEntityPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderStayRepository extends JpaRepository<OrderStayEntity, OrderStayEntityPK>,
        JpaSpecificationExecutor<OrderStayEntity> {

    OrderStayEntity findFirstByOrderId(long orderId);

    Page<OrderStayEntity> findAllByOrderId(long orderId, Pageable pageable);
}
