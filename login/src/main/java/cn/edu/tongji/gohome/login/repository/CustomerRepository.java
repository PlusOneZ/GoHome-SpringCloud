package cn.edu.tongji.gohome.login.repository;

import cn.edu.tongji.gohome.login.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * CustomerRepository
 *
 * @author 卓正一
 * @since 2021/11/22 8:57 PM
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByCustomerPhone(String phone);

    CustomerEntity findFirstByCustomerPhone(String phone);
}
