package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.CouponTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 梁乔 2021/11/30
 **/
public interface CouponTypeRepository extends JpaRepository<CouponTypeEntity,Integer>{
    CouponTypeEntity findByCouponTypeId(int couponTypeId);
}
