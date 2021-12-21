package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface AdministratorEntityRepository extends JpaRepository<AdministratorEntity, Integer>, JpaSpecificationExecutor<AdministratorEntity> {

    @Query("select distinct a from AdministratorEntity a where a.adminName = ?1")
    AdministratorEntity findDistinctByAdminName(String name);
}