package cn.edu.tongji.gohome.gateway.service.impl;

import cn.edu.tongji.gohome.gateway.model.AdministratorEntity;
import cn.edu.tongji.gohome.gateway.model.CustomerEntity;
import cn.edu.tongji.gohome.gateway.repository.AdminRepository;
import cn.edu.tongji.gohome.gateway.repository.CustomerRepository;
import cn.edu.tongji.gohome.gateway.repository.HostRepository;
import cn.edu.tongji.gohome.gateway.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * LoginServiceImpl
 *
 * @author 卓正一
 * @since 2021/11/22 9:56 PM
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    CustomerRepository customerRepository;

    @Resource
    AdminRepository adminRepository;

    /**
     * checkUserLogin
     * @return true for login success, false otherwise
     * @author 卓正一
     * @since 2021-11-22 10:16 PM
     */
    @Override
    public Boolean checkUserLogin(String userPhoneCode, String userPhone, String password) {
        Optional<CustomerEntity> customer = customerRepository.findByCustomerPhoneCodeAndCustomerPhone(userPhoneCode, userPhone);
        return customer.map(customerEntity -> customerEntity.getCustomerPassword().equals(password)).orElse(false);
    }

    /**
     * checkAdminLogin
     * @return true for login success, false otherwise
     * @author 卓正一
     * @since 2021-11-22 10:16 PM
     */
    @Override
    public Boolean checkAdminLogin(String adminName, String password) {
        Optional<AdministratorEntity> administrator = adminRepository.findByAdminName(adminName);
        return administrator.map(administratorEntity -> administratorEntity.getAdminPassword().equals(password)).orElse(false);
    }

    /**
     * @return customer id, -1 for error //TODO add check for id in backend
     * @author 卓正一
     * @since 2021-11-22 10:15 PM
     */
    @Override
    public Long getCustomerIdByPhone(String phoneCode, String phone) {
        Optional<CustomerEntity> customer = customerRepository.findByCustomerPhoneCodeAndCustomerPhone(phoneCode, phone);
        return customer.map(CustomerEntity::getCustomerId).orElse(-1L);
    }

    /**
     * @return admin id, -1 for error //TODO add check for id in backend
     * @author 卓正一
     * @since 2021-11-22 10:15 PM
     */
    @Override
    public Integer getAdminIdByName(String adminName) {
        return adminRepository.findByAdminName(adminName).map(AdministratorEntity::getAdminId).orElse(-1);
    }


}
