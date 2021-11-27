package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostReplyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PostReplyRepository extends JpaRepository<PostReplyEntity, Long>, JpaSpecificationExecutor<PostReplyEntity> {


    @Query("select p from PostReplyEntity p where p.preReplyId is null and p.postId = ?1")
    Page<PostReplyEntity> findAllByPostId(long postId, Pageable pageable);

    Page<PostReplyEntity> findAllByPreReplyId(long replyId, Pageable pageable);
}