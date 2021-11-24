package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.HostCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * HostCommentRepository类的DAO
 * @author 梁乔
 * @date 2021/11/23 11:22 
 */
public interface HostCommentRepository extends JpaRepository<HostCommentEntity, Long> {
    HostCommentEntity findByOrderId(long orderId);
}