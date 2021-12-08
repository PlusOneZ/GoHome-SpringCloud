package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorEntityRepository extends JpaRepository<AdministratorEntity, Integer> {
    boolean existsByAdminId(int adminId);
}