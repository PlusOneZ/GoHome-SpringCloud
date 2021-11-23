package cn.edu.tongji.gohome.login.service.exception;

/**
 * UserNotExistException
 *
 * @author 卓正一
 * @since 2021/11/23 8:34 PM
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("User does not exist!");
    }
}
