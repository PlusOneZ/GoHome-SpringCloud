package
        cn.edu.tongji.gohome.order.config;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * config before the application running.
 *
 * @className: ApplicationConfigRunner
 * @author: loey
 * @date: 2021-11-23 15:55
 **/
@Component
public class ApplicationConfigRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        IdGeneratorOptions options = new IdGeneratorOptions((short) 1);
        YitIdHelper.setIdGenerator(options);
        System.out.println("Id生成器初始化配置完成");
    }
}