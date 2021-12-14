package cn.edu.tongji.gohome.login.service.impl;

import cn.edu.tongji.gohome.login.model.CustomerEntity;
import cn.edu.tongji.gohome.login.model.HostEntity;
import cn.edu.tongji.gohome.login.payload.IdVerificationResult;
import cn.edu.tongji.gohome.login.payload.SmsSendResult;
import cn.edu.tongji.gohome.login.repository.AdminRepository;
import cn.edu.tongji.gohome.login.repository.CustomerRepository;
import cn.edu.tongji.gohome.login.repository.HostRepository;
import cn.edu.tongji.gohome.login.service.EncryptService;
import cn.edu.tongji.gohome.login.service.IdVerificationService;
import cn.edu.tongji.gohome.login.service.SignupService;
import cn.edu.tongji.gohome.login.service.SmsService;
import cn.edu.tongji.gohome.login.service.exception.UserAlreadyExists;
import cn.edu.tongji.gohome.login.service.exception.UserNotExistException;
import cn.edu.tongji.gohome.login.utils.RandomSmsCodeUtil;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * SignupServiceImpl
 *
 * @author 卓正一
 * @since 2021/11/23 8:31 PM
 */
@Service
public class SignupServiceImpl implements SignupService {

    @Resource
    CustomerRepository customerRepository;

    @Resource
    HostRepository hostRepository;

    @Resource
    AdminRepository adminRepository;

    @Resource
    EncryptService encryptService;

    @Resource
    IdVerificationService idVerificationService;

    @Resource
    SmsService smsService;

    @Override
    public Boolean checkPhoneAvailable(String phone) {
        return customerRepository.findByCustomerPhone(phone).isEmpty();
    }

    @Override
    public void changeCustomerPassword(String phone, String newPassword) {
        Optional<CustomerEntity> customer = customerRepository.findByCustomerPhone(phone);
        if (customer.isPresent()) {
            CustomerEntity customerEntity = customer.get();
            String pwdEncrypted = encryptService.encryptPassword(newPassword);
            customerEntity.setCustomerPassword(pwdEncrypted);
            customerRepository.save(customerEntity);
        } else {
            throw new UserNotExistException();
        }
    }

    @Override
    public void changeCustomerPassword(Long userId, String newPassword) {
        Optional<CustomerEntity> customer = customerRepository.findById(userId);
        if (customer.isPresent()) {
            CustomerEntity customerEntity = customer.get();
            String pwdEncrypted = encryptService.encryptPassword(newPassword);
            customerEntity.setCustomerPassword(pwdEncrypted);
            customerRepository.save(customerEntity);
        } else {
            throw new UserNotExistException();
        }
    }

    @Override
    public SmsSendResult sendSmsVerificationCode(String phone) {
        String code = RandomSmsCodeUtil.getCode();

        SmsSendResult smsSendResult = new SmsSendResult();
        // TODO: modify to usable edition.
        // copied example code
        if (smsService.sendSmsToClient(phone, code)) {
            smsSendResult.setCode(code);
            smsSendResult.setSendstate(true);
        } else {
            smsSendResult.setSendstate(false);
        }
        return smsSendResult;
    }

    @Override
    public IdVerificationResult idVerification(String base64img) {
        IdVerificationResult result = idVerificationService.verifyIdImage(base64img);

        // check if duplicated
        if (!result.getTrueID().isEmpty()) {
            Optional<HostEntity> host = hostRepository.findByHostResidentId(result.getTrueID());
            if (host.isPresent()) {
                result.setVerifyResult(2);
            }
        }
        return result;
    }

    @Override
    public Long customerSignup(String phoneCode, String phone, String password, String username) {
        return customerSignup(phoneCode, phone, password, username, null);
    }

    @Override
    public Long customerSignup(String phoneCode, String phone, String password, String username, String gender) {
        if (!checkPhoneAvailable(phone)) {
            // 已经有这个用户了
            throw new UserAlreadyExists();
        }

        CustomerEntity customer = new CustomerEntity();

        customer.setCustomerId(YitIdHelper.nextId()); // 自动生成
        String pwdEncrypted = encryptService.encryptPassword(password);
        customer.setCustomerPassword(pwdEncrypted);
        customer.setCustomerName(username);
        customer.setCustomerPhone(phone);
        customer.setCustomerPhoneCode(phoneCode);
        customer.setCustomerGender(gender);

        customerRepository.save(customer);

        return customer.getCustomerId();
    }

    @Override
    public void hostSignup(String phoneCode, String phone, String password, String username, String residentId, String realName, String gender) {
        Long id = customerSignup(phoneCode, phone, password, username, gender);

        // user initialized and saved

        hostSignup(residentId, realName, id);
    }

    @Override
    public void hostSignup(String residentId, String realName, Long customerId) {
        Optional<CustomerEntity> customer = customerRepository.findById(customerId);

        if (customer.isEmpty()) {
            throw new UserNotExistException();
        }
        // user initialized and saved

        HostEntity host = new HostEntity();
        host.setCustomerId(customerId);
        host.setHostRealName(realName);
        host.setHostResidentId(residentId);

        hostRepository.save(host);
    }

    @Override
    public void setCustomerGender(Long customerId, String gender) {
        Optional<CustomerEntity> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new UserNotExistException();
        }
        CustomerEntity customerEntity = customer.get();
        customerEntity.setCustomerGender(gender);
        customerRepository.save(customerEntity);
    }
}
