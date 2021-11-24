package cn.edu.tongji.gohome.login.service.exception;

/**
 * LoginRequired
 *
 * @author 卓正一
 * @since 2021/11/24 10:17 AM
 */
public class LoginRequiredException extends RuntimeException{
    public LoginRequiredException() {
        super("Please login to perform operation!");
    }
}
