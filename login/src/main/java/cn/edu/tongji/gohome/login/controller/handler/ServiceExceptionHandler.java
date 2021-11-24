package cn.edu.tongji.gohome.login.controller.handler;

import cn.edu.tongji.gohome.login.service.exception.LoginRequiredException;
import cn.edu.tongji.gohome.login.service.exception.UserAlreadyExists;
import cn.edu.tongji.gohome.login.service.exception.UserNotExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ServiceExceptionHandler
 *
 * @author 卓正一
 * @since 2021/11/24 10:11 AM
 */
@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<String> handleNotExist(UserNotExistException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<String> handleAlreadyExists(UserAlreadyExists e) {
        return ResponseEntity.status(403).body(e.getMessage());
    }

    @ExceptionHandler(LoginRequiredException.class)
    public ResponseEntity<String> handleLoginRequired(LoginRequiredException e) {
        return ResponseEntity.status(401).body(e.getMessage());
    }
}
