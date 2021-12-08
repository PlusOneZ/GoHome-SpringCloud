package cn.edu.tongji.gohome.login.service;

import cn.edu.tongji.gohome.login.payload.IdVerificationResult;
import org.springframework.stereotype.Service;

/**
 * IdVerificationService
 *
 * @author 卓正一
 * @since 2021/12/8 10:43 AM
 */
@Service
public interface IdVerificationService {

    IdVerificationResult verifyIdImage(String base64Image);
}
