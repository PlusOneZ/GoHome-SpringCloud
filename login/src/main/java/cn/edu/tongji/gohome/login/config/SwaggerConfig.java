package cn.edu.tongji.gohome.login.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * SwaggerConfig
 * <b>API Doc in <a href="http://localhost:8082/swagger-ui/index.html">http://domain_name:8082/swagger-ui/index.html</a></b>
 *
 * @author 卓正一
 * @since 2021/11/27 8:16 AM
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Login and Signup Service API Document.")//标题
                .description("Provide RESTful APIs for user login and signup.")//描述
                //附加信息
                .contact(new Contact("PlusOneZ", "https://www.github.com/PlusOneZ", "zhuozhengyi@iCloud.com"))
                .version("1.0")//版本
                .build();
    }
}
