package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.HostGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * HostLevelRepository接口
 *
 * @author 汪明杰
 * @date 2021/11/22 22:34
 */
public interface HostGroupRepository extends JpaRepository<HostGroupEntity, Integer>,
        JpaSpecificationExecutor<HostGroupEntity> {
}
