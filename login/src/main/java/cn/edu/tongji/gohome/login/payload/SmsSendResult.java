package cn.edu.tongji.gohome.login.payload;

import lombok.Data;

/**
 * smsSendResult
 *
 * @author 卓正一
 * @since 2021/12/14 3:54 PM
 */
@Data
public class SmsSendResult {
    private String code;
    private Boolean sendstate;
}
