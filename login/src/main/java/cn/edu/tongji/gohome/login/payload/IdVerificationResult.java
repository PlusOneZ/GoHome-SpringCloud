package cn.edu.tongji.gohome.login.payload;

import lombok.Data;

/**
 * IdVerificationResult
 *
 * @author 卓正一
 * @since 2021/12/8 10:38 AM
 */
@Data
public class IdVerificationResult {

    private Integer verifyResult; // 0 for valid, 1 for invalid, 2 for duplicated
    private String trueID;
    private String trueName;

}
