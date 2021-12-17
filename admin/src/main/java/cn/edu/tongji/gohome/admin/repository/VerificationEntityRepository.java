package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.VerificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface VerificationEntityRepository extends JpaRepository<VerificationEntity, Long>, JpaSpecificationExecutor<VerificationEntity> {
    @Query("select v from VerificationEntity v")
    Page<VerificationEntity> findAllBy(Pageable pageable);
}