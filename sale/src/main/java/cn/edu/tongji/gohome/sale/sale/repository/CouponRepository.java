package cn.edu.tongji.gohome.sale.sale.repository;

import cn.edu.tongji.gohome.sale.sale.model.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 梁乔 2021/11/24
 **/
public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
    CouponEntity findByCouponId(long couponId);
}
