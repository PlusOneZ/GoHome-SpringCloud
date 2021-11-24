package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.StayTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StayTypeRepository extends JpaRepository<StayTypeEntity, String>,
        JpaSpecificationExecutor<StayTypeEntity> {
}
