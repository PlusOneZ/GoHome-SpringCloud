package cn.edu.tongji.gohome.login.service.impl;

import cn.edu.tongji.gohome.login.model.CustomerEntity;
import cn.edu.tongji.gohome.login.model.HostEntity;
import cn.edu.tongji.gohome.login.repository.AdminRepository;
import cn.edu.tongji.gohome.login.repository.CustomerRepository;
import cn.edu.tongji.gohome.login.repository.HostRepository;
import cn.edu.tongji.gohome.login.service.SignupService;
import cn.edu.tongji.gohome.login.service.exception.UserAlreadyExists;
import cn.edu.tongji.gohome.login.service.exception.UserNotExistException;
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

    @Override
    public Boolean checkPhoneAvailable(String phoneCode, String phone) {
        return customerRepository.findByCustomerPhoneCodeAndCustomerPhone(phoneCode, phone).isEmpty();
    }

    @Override
    public void changeCustomerPassword(String phoneCode, String phone, String newPassword) {
        Optional<CustomerEntity> customer = customerRepository.findByCustomerPhoneCodeAndCustomerPhone(phoneCode, phone);
        if (customer.isPresent()) {
            CustomerEntity customerEntity = customer.get();
            customerEntity.setCustomerPassword(newPassword);
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
            customerEntity.setCustomerPassword(newPassword);
            customerRepository.save(customerEntity);
        } else {
            throw new UserNotExistException();
        }
    }

    @Override
    public Long customerSignup(String phoneCode, String phone, String password, String username) {
        return customerSignup(phoneCode, phone, password, username, null);
    }

    @Override
    public Long customerSignup(String phoneCode, String phone, String password, String username, String gender) {
        if (!checkPhoneAvailable(phoneCode, phone)) {
            // 已经有这个用户了
            throw new UserAlreadyExists();
        }

        CustomerEntity customer = new CustomerEntity();

        customer.setCustomerId(YitIdHelper.nextId()); // 自动生成
        customer.setCustomerPassword(password);
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
}
