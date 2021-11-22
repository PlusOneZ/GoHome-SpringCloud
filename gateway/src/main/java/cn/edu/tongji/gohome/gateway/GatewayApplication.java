package cn.edu.tongji.gohome.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    private String getUserId() {
        return "";
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        System.out.println("hello");
        return builder.routes()
                .route(p -> p
                        .path("api/*/admin/")
                        .filters(f -> f.addRequestParameter("userId", getUserId()))
                        .uri("http://locolhost:8081"))
                .build();
    }


}
