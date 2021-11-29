package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.ViewStayCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewStayCustomerRepository extends JpaRepository<ViewStayCustomerEntity, Long> {
    ViewStayCustomerEntity findByStayId(long stayId);
}
