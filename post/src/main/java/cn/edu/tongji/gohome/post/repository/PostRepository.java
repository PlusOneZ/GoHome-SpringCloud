package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<PostEntity, Long>, JpaSpecificationExecutor<PostEntity> {

    Page<PostEntity> findAllByCustomerId(Long customerId, Pageable pageable);

    @Query(value = "select p.post_id,p.post_time,p.post_content,p.post_theme,p.reply_count,p.like_count,p.customer_id from post_tag as t inner join post as p on p.post_id = t.post_id where t.post_tag = ?1",nativeQuery = true)
    Page<PostEntity> findAllByPostTag(String tag, Pageable pageable);

    PostEntity findOneByPostId(long postId);
}