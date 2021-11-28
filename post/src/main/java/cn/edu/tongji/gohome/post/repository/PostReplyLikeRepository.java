package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostLikeEntity;
import cn.edu.tongji.gohome.post.model.PostReplyLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostReplyLikeRepository extends JpaRepository<PostReplyLikeEntity, Long>, JpaSpecificationExecutor<PostReplyLikeEntity> {
    PostLikeEntity findOneByReplyIdAndCustomerId(long replyId, long customerId);
}