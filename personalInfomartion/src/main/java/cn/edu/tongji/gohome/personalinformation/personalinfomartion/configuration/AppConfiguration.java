package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO:此处写AppConfiguration类的描述
 * @author 梁乔
 * @date 2021/11/21 15:50 
 */
@Configuration
public class AppConfiguration implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {//临时声明的类
            @Override
            public void  addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")//所有的api均允许访问
                        .allowedOrigins("*");
            }
        };
    }
}