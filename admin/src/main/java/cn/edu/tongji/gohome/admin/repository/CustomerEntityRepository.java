package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, Long>, JpaSpecificationExecutor<CustomerEntity> {
    @Query("select c from CustomerEntity c where c.customerId = ?1")
    CustomerEntity findOneByCustomerId(long customerId);

    @Transactional
    @Modifying
    CustomerEntity saveAndFlush(CustomerEntity customer);
}