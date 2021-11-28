package
        cn.edu.tongji.gohome.payment.config;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * class description
 *
 * @author : loey
 * @className : ApplicationConfigRunner
 * @since : 2021-11-24 22:07
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