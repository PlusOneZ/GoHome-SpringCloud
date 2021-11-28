package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PostLikeRepository extends JpaRepository<PostLikeEntity, Long>, JpaSpecificationExecutor<PostLikeEntity> {
    PostLikeEntity findOneByPostIdAndCustomerId(long postId, long customerId);

    Boolean existsByPostIdAndCustomerId(long postId, long customerId);

    @Modifying
    @Transactional
    @Query("delete from PostLikeEntity p where p.postId = ?1 and p.customerId = ?2")
    void deleteByPostIdAndCustomerId(long postId, long customerId);
}
