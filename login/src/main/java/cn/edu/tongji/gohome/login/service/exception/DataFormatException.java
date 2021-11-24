package cn.edu.tongji.gohome.login.service.exception;

/**
 * DataFormatException
 *
 * @author 卓正一
 * @since 2021/11/24 9:19 PM
 */
public class DataFormatException extends RuntimeException {
    public DataFormatException() {
        super("Data format not correct");
    }
}
