package cn.edu.tongji.gohome.login.repository;

import cn.edu.tongji.gohome.login.model.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdministratorEntity, Integer> {

    Optional<AdministratorEntity> findByAdminName(String name);

}
