package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long>, JpaSpecificationExecutor<OrderEntity> {
    @Query("select o from OrderEntity o where o.orderId = ?1")
    OrderEntity findOneByOrderId(long orderId);
}