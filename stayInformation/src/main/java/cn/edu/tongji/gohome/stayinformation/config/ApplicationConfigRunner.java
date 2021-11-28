package cn.edu.tongji.gohome.stayinformation.config;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * ApplicationConfigRunner
 *
 * @author 汪明杰
 * @since 2021/11/24 9:38 PM
 */
@Component
public class ApplicationConfigRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception{
        IdGeneratorOptions options = new IdGeneratorOptions((short) 2);
        YitIdHelper.setIdGenerator(options);
        System.out.println("Id生成器初始化配置完成");
    }
}