package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.StayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface StayEntityRepository extends JpaRepository<StayEntity, Long>, JpaSpecificationExecutor<StayEntity> {

    @Query("select s from StayEntity s where s.stayId = ?1")
    StayEntity findOneByStayId(Long stayId);

    @Transactional
    @Modifying
    StayEntity saveAndFlush(StayEntity entity);
}