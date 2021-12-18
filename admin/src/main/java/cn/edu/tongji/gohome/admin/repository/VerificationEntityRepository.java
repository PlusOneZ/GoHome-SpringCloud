package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.VerificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface VerificationEntityRepository extends JpaRepository<VerificationEntity, Long>, JpaSpecificationExecutor<VerificationEntity> {
    @Query("select v from VerificationEntity v where v.verificationResult=false")
    Page<VerificationEntity> findAllBy(Pageable pageable);

    @Transactional
    @Modifying
    VerificationEntity saveAndFlush(VerificationEntity entity);

    @Query("select v from VerificationEntity v where v.stayId = ?1")
    VerificationEntity findOneByStayId(Long stayId);

}