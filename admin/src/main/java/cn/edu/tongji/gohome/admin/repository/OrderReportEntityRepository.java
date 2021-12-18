package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.OrderReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.HashMap;

public interface OrderReportEntityRepository extends JpaRepository<OrderReportEntity, Long>, JpaSpecificationExecutor<OrderReportEntity> {

    @Query("select o from OrderReportEntity o where o.orderId = ?1")
    OrderReportEntity findOneByOrderId(Long order);

    @Transactional
    @Modifying
    OrderReportEntity saveAndFlush(OrderReportEntity entity);

    @Query("select o from OrderReportEntity o where o.isDealt=0")
    Page<OrderReportEntity> findAllBy(Pageable pageable);
}