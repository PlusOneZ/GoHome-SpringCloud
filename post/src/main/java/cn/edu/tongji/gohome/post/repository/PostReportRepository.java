package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostReportEntity;
import cn.edu.tongji.gohome.post.model.PostReportEntityPK;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

@DynamicInsert
@DynamicUpdate
public interface PostReportRepository
extends JpaRepository<PostReportEntity, PostReportEntityPK>,
        JpaSpecificationExecutor<PostReportEntity> {
    PostReportEntity findFirstByReportCustomerIdAndBeReportedCustomerId(
            Long reportCustomerId, Long beReportedCustomerId
    );


}
