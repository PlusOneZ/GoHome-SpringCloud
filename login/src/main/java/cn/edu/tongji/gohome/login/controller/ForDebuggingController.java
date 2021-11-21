package cn.edu.tongji.gohome.login.controller;

import cn.edu.tongji.gohome.login.model.CustomerEntity;
import cn.edu.tongji.gohome.login.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * ForDebugingController
 *
 * @author 卓正一
 * @since 2021/11/19 6:58 PM
 */
@RestController
@RequestMapping("api/v1/debugging/")
public class ForDebuggingController {

    @Resource
    private CustomerRepository customerRepository;

    @RequestMapping("all/customers/raw")
    public List<CustomerEntity> getAllCustomersRawData() {
        return customerRepository.findAll();
    }

    @RequestMapping("customer")
    ResponseEntity<CustomerEntity> getCustomerBySomething(
            @RequestParam Long id
    ) {
        Optional<CustomerEntity> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(401).body(null));
    }
}
