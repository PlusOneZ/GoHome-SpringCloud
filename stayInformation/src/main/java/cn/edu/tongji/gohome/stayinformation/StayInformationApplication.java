package cn.edu.tongji.gohome.stayinformation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
public class StayInformationApplication {

    public static void main(String[] args) {
        SpringApplication.run(StayInformationApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry
//                        .addMapping("/**")
//                        .allowedOrigins(
//                                "http://localhost:8080",
//                                "http://*.guisu.website",
//                                "https://*.guisu.website",
//                                "http://localhost:8081"
//                        )
//                        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
//                        .allowCredentials(true)
//                        .maxAge(3600);
//            }
//        };
//    }

}
