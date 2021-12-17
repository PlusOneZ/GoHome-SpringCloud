package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.OrderReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;

public interface OrderReportEntityRepository extends JpaRepository<OrderReportEntity, Long>, JpaSpecificationExecutor<OrderReportEntity> {
    @Query("select o from OrderReportEntity o  where o.reportId = ?1")
    HashMap<String,Object> findOneByReportId(Long reportId);

    @Query("select o from OrderReportEntity o")
    Page<OrderReportEntity> findAllBy(Pageable pageable);

}