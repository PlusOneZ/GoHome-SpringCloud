package cn.edu.tongji.gohome.login.dto;

import lombok.Data;

/**
 * VerifyCodeToken
 *
 * @author 卓正一
 * @since 2021/12/6 4:54 PM
 */
@Data
public class VerifyCodeToken {
    private String codeImg;
    private String token;
}
