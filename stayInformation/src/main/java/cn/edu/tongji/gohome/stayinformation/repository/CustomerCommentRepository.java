package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.CustomerCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerCommentRepository extends JpaRepository<CustomerCommentEntity, Integer>,
        JpaSpecificationExecutor<CustomerCommentEntity> {
    CustomerCommentEntity findFirstByOrderId(long orderId);


}
