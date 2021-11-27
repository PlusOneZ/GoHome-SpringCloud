package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostReplyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostReplyRepository extends JpaRepository<PostReplyEntity, Long>, JpaSpecificationExecutor<PostReplyEntity> {
    Page<PostReplyEntity> findAllByPostId(long postId, Pageable pageable);

}