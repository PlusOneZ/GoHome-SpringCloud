package cn.edu.tongji.gohome.gateway.repository;

import cn.edu.tongji.gohome.gateway.model.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HostRepository extends JpaRepository<HostEntity, Integer> {
    Optional<HostEntity> findByCustomerId(Long cid);
}
