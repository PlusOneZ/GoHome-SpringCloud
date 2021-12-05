package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.CustomerGroupCouponEntity;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.CustomerGroupCouponEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 梁乔 2021/11/30
 **/
public interface CustomerCouponRepository extends JpaRepository<CustomerGroupCouponEntity, CustomerGroupCouponEntityPK> {
    List<CustomerGroupCouponEntity> findAllByCustomerLevel(int customerLevel);
}
