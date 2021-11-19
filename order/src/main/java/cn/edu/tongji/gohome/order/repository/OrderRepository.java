package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    public List<OrderEntity> findAllByCustomerId(Long customerId);
}
