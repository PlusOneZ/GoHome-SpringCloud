package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.PostReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostReplyEntityRepository extends JpaRepository<PostReplyEntity, Long>, JpaSpecificationExecutor<PostReplyEntity> {
}