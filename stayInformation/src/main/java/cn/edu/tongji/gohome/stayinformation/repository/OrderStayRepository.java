package cn.edu.tongji.gohome.stayinformation.repository;


import cn.edu.tongji.gohome.stayinformation.model.OrderStayEntity;
import cn.edu.tongji.gohome.stayinformation.model.OrderStayEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface OrderStayRepository extends JpaRepository<OrderStayEntity, OrderStayEntityPK>,
        JpaSpecificationExecutor<OrderStayEntity> {
    OrderStayEntity findFirstByOrderId(long orderId);

    List<OrderStayEntity> findAllByStayId(long StayId);
}
