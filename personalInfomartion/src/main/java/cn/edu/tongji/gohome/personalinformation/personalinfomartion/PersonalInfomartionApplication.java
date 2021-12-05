package cn.edu.tongji.gohome.personalinformation.personalinfomartion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PersonalInfomartionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalInfomartionApplication.class, args);
    }

}
