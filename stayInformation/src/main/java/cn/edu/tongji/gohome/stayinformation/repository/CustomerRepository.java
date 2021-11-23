package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.CustomerCommentEntity;
import cn.edu.tongji.gohome.stayinformation.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * CustomerRepository类
 *
 * @author 汪明杰
 * @date 2021/11/22 19:10
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>,
        JpaSpecificationExecutor<CustomerEntity> {

    CustomerEntity findCustomerEntityByCustomerId(long customerId);

}
