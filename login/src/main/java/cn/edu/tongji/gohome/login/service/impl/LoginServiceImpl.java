package cn.edu.tongji.gohome.login.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.login.dto.CustomerBriefInfoDTO;
import cn.edu.tongji.gohome.login.dto.VerifyCodeToken;
import cn.edu.tongji.gohome.login.model.AdministratorEntity;
import cn.edu.tongji.gohome.login.model.CustomerEntity;
import cn.edu.tongji.gohome.login.repository.AdminRepository;
import cn.edu.tongji.gohome.login.repository.CustomerRepository;
import cn.edu.tongji.gohome.login.service.EncryptService;
import cn.edu.tongji.gohome.login.service.LoginService;
import cn.edu.tongji.gohome.login.service.exception.DataFormatException;
import cn.edu.tongji.gohome.login.service.exception.UserNotExistException;

import cn.edu.tongji.gohome.login.utils.VerifyCodeUtil;

import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.io.IOException;
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

    @Resource
    EncryptService encryptService;

    /**
     * checkUserLogin
     *
     * @return true for login success, false otherwise
     * @author 卓正一
     * @since 2021-11-22 10:16 PM
     */
    @Override
    public Boolean checkUserLogin(String userPhone, String password) {
        // TODO: Encrypt this password, maybe a password encryptor?
        Optional<CustomerEntity> customer = customerRepository.findByCustomerPhone(userPhone);
        return customer.map(customerEntity ->
                encryptService.comparePasswords(customerEntity.getCustomerPassword(), password)
        ).orElse(false);
    }

    /**
     * checkAdminLogin
     *
     * @return true for login success, false otherwise
     * @author 卓正一
     * @since 2021-11-22 10:16 PM
     */
    @Override
    public Boolean checkAdminLogin(String adminName, String password) {
        Optional<AdministratorEntity> administrator = adminRepository.findByAdminName(adminName);
        String pwdEncrypted = encryptService.encryptPassword(password);
        return administrator.map(administratorEntity ->
                encryptService.comparePasswords(administratorEntity.getAdminPassword(), password)
        ).orElse(false);
    }

    /**
     * @return customer id, -1 for error //TODO add check for id in backend
     * @author 卓正一
     * @since 2021-11-22 10:15 PM
     */
    @Override
    public Long getCustomerIdByPhone(String phone) {
        Optional<CustomerEntity> customer = customerRepository.findByCustomerPhone(phone);
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

    @Override
    public CustomerBriefInfoDTO getCustomerBriefInfoByCustomerId(Long id) {
        Optional<CustomerEntity> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            CustomerBriefInfoDTO briefInfoDTO = new CustomerBriefInfoDTO();
            briefInfoDTO.fillByCustomerEntity(customer.get(), StpUtil.getPermissionList());
            return briefInfoDTO;
        } else {
            throw new UserNotExistException();
        }
    }

    @Override
    public VerifyCodeToken getVerificationCodeAndToken() {
        String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
        try {
            String image = VerifyCodeUtil.base64StringOfCode(verifyCode);
            VerifyCodeToken vct = new VerifyCodeToken();
            vct.setCodeImg("data:image/jpg;base64," + image);

            // TODO: Add token for validation here
            vct.setToken(verifyCode);
            return vct;
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataFormatException();
        }
    }

    @Override
    public String getCustomerPhoneById(Long id) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get().getCustomerPhone();
        } else {
            throw new UserNotExistException();
        }
    }


}
