package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.CustomerGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 梁乔 2021/11/30
 **/
public interface CustomerGroupRepository extends JpaRepository<CustomerGroupEntity,Integer> {
    List<CustomerGroupEntity> findAllBy();
}
