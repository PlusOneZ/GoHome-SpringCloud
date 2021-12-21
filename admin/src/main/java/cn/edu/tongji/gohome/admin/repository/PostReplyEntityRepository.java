package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.PostReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PostReplyEntityRepository extends JpaRepository<PostReplyEntity, Long>, JpaSpecificationExecutor<PostReplyEntity> {
    @Query("delete from PostReplyEntity p where p.customerId = ?1")
    @Modifying
    @Transactional
    void deleteByCustomerId(Long customerId);
}