package cn.edu.tongji.gohome.login.service.exception;

/**
 * AliyunSmsCodeException
 *
 * @author 卓正一
 * @since 2021/12/6 9:01 PM
 */
public class AliyunSmsCodeException extends RuntimeException {
    AliyunSmsCodeException() {
        super("Aliyun SMS API error.");
    }
}
