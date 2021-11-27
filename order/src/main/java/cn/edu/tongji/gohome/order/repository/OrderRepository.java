package cn.edu.tongji.gohome.order.repository;


import cn.edu.tongji.gohome.order.model.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>, JpaSpecificationExecutor<OrderEntity> {

    Page<OrderEntity> findAllByCustomerId(Long customerId, Pageable pageable);

    OrderEntity findFirstByOrderId(Long orderId);

    @Transactional
    void deleteAllByOrderId(Long orderId);



}
