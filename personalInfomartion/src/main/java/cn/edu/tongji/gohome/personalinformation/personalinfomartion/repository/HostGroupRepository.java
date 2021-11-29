package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.HostGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 梁乔 2021/11/29
 **/
public interface HostGroupRepository extends JpaRepository<HostGroupEntity,Integer> {
    HostGroupEntity getByHostLevel(int hostLevel);
}
