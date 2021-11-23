package cn.edu.tongji.gohome.gateway.service.impl;

import cn.edu.tongji.gohome.gateway.repository.AdminRepository;
import cn.edu.tongji.gohome.gateway.repository.CustomerRepository;
import cn.edu.tongji.gohome.gateway.repository.HostRepository;
import cn.edu.tongji.gohome.gateway.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PermissionServiceImpl
 *
 * @author 卓正一
 * @since 2021/11/22 10:47 PM
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    CustomerRepository customerRepository;

    @Resource
    HostRepository hostRepository;

    @Resource
    AdminRepository adminRepository;

    @Override
    public Boolean checkUserIsHost(Long id) {
        return hostRepository.findByCustomerId(id).isPresent();
    }

    @Override
    public Boolean checkIsUser(Long id) {
        return customerRepository.findById(id).isPresent();
    }

    @Override
    public Boolean checkIsAdmin(Long id) {
        return adminRepository.findById(id.intValue()).isPresent();
    }
}
