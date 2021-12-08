package cn.edu.tongji.gohome.login.dto;

import cn.edu.tongji.gohome.login.model.CustomerEntity;
import lombok.Data;

import java.util.List;

/**
 * CustomerDTO
 *
 * @author 卓正一
 * @since 2021/12/6 4:25 PM
 */
@Data
public class CustomerBriefInfoDTO {

    private Long userId;

    private String userName;

    private String userAvatar;

    private List<String> userPermissions;

    public void fillByCustomerEntity(CustomerEntity customer, List<String> permissions) {
        this.setUserId(customer.getCustomerId());
        this.setUserAvatar(customer.getCustomerAvatarLink());
        this.setUserName(customer.getCustomerName());
        this.setUserPermissions(permissions);
    }
}
