package cn.edu.tongji.gohome.login.repository;

import cn.edu.tongji.gohome.login.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CustomerRepository
 *
 * @author 卓正一
 * @since  2021/11/19 6:48 PM
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
