package cn.edu.tongji.gohome.stayinformation.service.impl;

import cn.edu.tongji.gohome.stayinformation.model.HostEntity;
import cn.edu.tongji.gohome.stayinformation.repository.HostRepository;
import cn.edu.tongji.gohome.stayinformation.service.HostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO:此处写HostServiceImpl类的描述
 *
 * @author 汪明杰
 * @date 2021/12/7 13:07
 */
@Service
public class HostServiceImpl implements HostService {

    @Resource
    HostRepository hostRepository;

    @Override
    public Integer findHostIdByCustomerId(long customerId){
        HostEntity hostEntity =
                hostRepository.findFirstByCustomerId(customerId);
        if (hostEntity==null){
            return null;
        }
        else{
            return hostEntity.getHostId();
        }
    }
}
