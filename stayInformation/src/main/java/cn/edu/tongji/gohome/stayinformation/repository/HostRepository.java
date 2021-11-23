package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.CustomerEntity;
import cn.edu.tongji.gohome.stayinformation.model.HostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * HostRepository接口
 *
 * @author 汪明杰
 * @date 2021/11/22 22:26
 */
public interface HostRepository extends JpaRepository<HostEntity, Integer>,
        JpaSpecificationExecutor<HostEntity> {


}
