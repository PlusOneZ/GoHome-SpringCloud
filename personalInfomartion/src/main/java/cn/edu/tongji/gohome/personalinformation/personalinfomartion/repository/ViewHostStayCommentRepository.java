package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;/**
 * @author 梁乔 2021/11/29
 **/

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.ViewHostStayCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 此处写ViewHostStayCommentRepository类的描述
 * @author 梁乔
 * @since 2021/11/29 20:29 
 */
public interface ViewHostStayCommentRepository extends JpaRepository<ViewHostStayCommentEntity, Integer> {
    List<ViewHostStayCommentEntity> findAllByHostId(int hostId);
}