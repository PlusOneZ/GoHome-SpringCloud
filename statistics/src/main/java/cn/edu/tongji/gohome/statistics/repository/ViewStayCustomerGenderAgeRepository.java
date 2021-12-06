package cn.edu.tongji.gohome.statistics.repository;

import cn.edu.tongji.gohome.statistics.model.ViewStayCustomerGenderAgeEntity;
import cn.edu.tongji.gohome.statistics.model.ViewStayCustomerGenderAgeEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ViewStayCustomerGenderAgeRepository
extends JpaRepository<ViewStayCustomerGenderAgeEntity,
        ViewStayCustomerGenderAgeEntityPK>,
        JpaSpecificationExecutor<ViewStayCustomerGenderAgeEntity> {
    List<ViewStayCustomerGenderAgeEntity> findAllByStayId(long stayId);
}
