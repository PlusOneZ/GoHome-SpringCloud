package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 用户信息实体的DAO
* @author 梁乔
* @since 2021-11-23 21:35
*/
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, JpaSpecificationExecutor<CustomerEntity> {
    CustomerEntity findFirstByCustomerId(Long customerId);
}
