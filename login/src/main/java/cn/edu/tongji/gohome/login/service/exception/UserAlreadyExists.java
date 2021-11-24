package cn.edu.tongji.gohome.login.service.exception;

/**
 * UserAlreadyExists
 *
 * @author 卓正一
 * @since 2021/11/23 8:48 PM
 */
public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists() {
        super("User already exists!");
    }
}
