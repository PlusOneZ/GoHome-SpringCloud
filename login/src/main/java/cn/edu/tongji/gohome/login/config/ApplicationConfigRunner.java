package cn.edu.tongji.gohome.login.config;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * ApplicationConfigRunner
 *
 * @author 卓正一
 * @since 2021/11/23 9:38 PM
 */
@Component
public class ApplicationConfigRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception{
        IdGeneratorOptions options = new IdGeneratorOptions((short) 42);
        YitIdHelper.setIdGenerator(options);
        System.out.println("Id生成器初始化配置完成");
    }
}