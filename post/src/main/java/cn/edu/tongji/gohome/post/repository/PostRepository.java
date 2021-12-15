package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long>, JpaSpecificationExecutor<PostEntity> {

    Page<PostEntity> findAllByCustomerIdOrderByPostTimeDesc(Long customerId, Pageable pageable);

    List<PostEntity> findAllByCustomerIdOrderByPostTimeDesc(Long customerId);

    PostEntity findOneByPostId(long postId);

    PostEntity saveAndFlush(PostEntity postEntity);

    Page<PostEntity> findAllByOrderByPostTimeDesc(Pageable pageable);

    @Transactional
    void deleteByPostId(long postId);
}