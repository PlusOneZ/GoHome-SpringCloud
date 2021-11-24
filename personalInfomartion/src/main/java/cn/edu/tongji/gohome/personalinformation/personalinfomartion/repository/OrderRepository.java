package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;/**
 * @author 梁乔 2021/11/23
 **/

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * TODO:此处写OrderRepository类的描述
 * @author 梁乔
 * @date 2021/11/23 16:17 
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByCustomerId(long customerId);
}