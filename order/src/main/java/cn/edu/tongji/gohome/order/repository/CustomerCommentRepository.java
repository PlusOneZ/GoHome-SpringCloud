package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.CustomerCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerCommentRepository extends JpaRepository<CustomerCommentEntity, Long>,
        JpaSpecificationExecutor<CustomerCommentEntity> {
    CustomerCommentEntity findFirstByOrderId(long orderId);

}
