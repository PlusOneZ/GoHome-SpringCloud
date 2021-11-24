package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 房东用户的DAO
* @author 梁乔
* @since 2021-11-23 21:36
*/
public interface HostRepository extends JpaRepository<HostEntity, Integer> {
    HostEntity findByHostId(Integer hostId);
}
