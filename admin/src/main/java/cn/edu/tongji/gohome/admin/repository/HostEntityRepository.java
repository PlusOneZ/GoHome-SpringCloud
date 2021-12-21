package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface HostEntityRepository extends JpaRepository<HostEntity, Integer>, JpaSpecificationExecutor<HostEntity> {


    @Query("select h from HostEntity h where h.hostId = ?1")
    HostEntity findOneByHostId(Integer hostId);
}