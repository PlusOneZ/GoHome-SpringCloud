package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, JpaSpecificationExecutor<CustomerEntity> {
    CustomerEntity findOneByCustomerId(long customerId);
}