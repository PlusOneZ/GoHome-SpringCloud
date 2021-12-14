package cn.edu.tongji.gohome.login.service;

/**
 * SmsService
 *
 * @author 卓正一
 * @since 2021/12/14 3:51 PM
 */
public interface SmsService {
    Boolean sendSmsToClient(String phone, String code);
}
