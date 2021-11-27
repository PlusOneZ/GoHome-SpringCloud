package cn.edu.tongji.gohome.sale.sale.repository;

import cn.edu.tongji.gohome.sale.sale.model.CouponTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 梁乔 2021/11/24
 **/
public interface CouponTypeRepository extends JpaRepository<CouponTypeEntity, Integer> {
    CouponTypeEntity findByCouponTypeId(int couponTypeId);
}
