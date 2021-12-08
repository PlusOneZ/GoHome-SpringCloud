package cn.edu.tongji.gohome.login.dto;

import lombok.Data;

/**
 * CustomerSignupDTO
 *
 * @author 卓正一
 * @since 2021/12/6 10:03 PM
 */
@Data
public class CustomerSignupDTO {
    private String phoneCode;
    private String phone;
    private String password;
    private String username;
}
