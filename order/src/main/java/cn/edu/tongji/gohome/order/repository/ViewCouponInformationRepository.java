package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.ViewCouponInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ViewCouponInformationRepository extends JpaRepository<ViewCouponInformationEntity,Long>,
        JpaSpecificationExecutor<ViewCouponInformationEntity> {

}
