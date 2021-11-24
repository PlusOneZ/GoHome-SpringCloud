package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.VerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VerificationRepository extends JpaRepository<VerificationEntity, Long>, JpaSpecificationExecutor<VerificationEntity> {
}