package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.BedEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BedRepository extends JpaRepository<BedEntity, String>,
        JpaSpecificationExecutor<BedEntity> {
}
