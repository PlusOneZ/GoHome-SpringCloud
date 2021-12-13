package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<HostEntity, Integer> {

    HostEntity findFirstByCustomerId(long customerId);
}
