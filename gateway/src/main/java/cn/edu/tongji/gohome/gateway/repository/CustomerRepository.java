package cn.edu.tongji.gohome.gateway.repository;

import cn.edu.tongji.gohome.gateway.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * CustomerRepository
 *
 * @author 卓正一
 * @since 2021/11/22 8:57 PM
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByCustomerPhoneCodeAndCustomerPhone(String phoneCode, String phone);
}
