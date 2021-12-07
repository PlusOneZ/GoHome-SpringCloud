package cn.edu.tongji.gohome.login.dto;

import cn.edu.tongji.gohome.login.model.CustomerEntity;
import lombok.Data;

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

    public void fillByCustomerEntity(CustomerEntity customer) {
        this.setUserId(customer.getCustomerId());
        this.setUserAvatar(customer.getCustomerAvatarLink());
        this.setUserName(customer.getCustomerName());
    }
}
