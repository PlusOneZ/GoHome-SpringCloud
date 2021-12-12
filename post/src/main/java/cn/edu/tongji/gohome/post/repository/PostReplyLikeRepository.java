package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostLikeEntity;
import cn.edu.tongji.gohome.post.model.PostReplyLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;

public interface PostReplyLikeRepository extends JpaRepository<PostReplyLikeEntity, Long>, JpaSpecificationExecutor<PostReplyLikeEntity> {
    PostReplyLikeEntity findOneByReplyIdAndCustomerId(long replyId, long customerId);

    Boolean existsByReplyIdAndCustomerId(long replyId, long customerId);

    @Query("delete from PostReplyLikeEntity p where p.replyId = ?1 and p.customerId = ?2")
    @Modifying
    @Transactional
    void deleteByReplyIdAndCustomerId(long replyId, long customerId);
}
