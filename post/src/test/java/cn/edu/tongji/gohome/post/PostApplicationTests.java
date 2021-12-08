package cn.edu.tongji.gohome.post;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PostApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void encryptPassword() {
    //public static void main(String[] args) {

        StandardPBEStringEncryptor standardPBEStringEncryptor =new StandardPBEStringEncryptor();
        /*配置文件中配置如下的算法*/
        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");
        /*配置文件中配置的password*/
        standardPBEStringEncryptor.setPassword("kao^QUan^yaNG^a^En");
        /*要加密的文本*/
        String name = standardPBEStringEncryptor.encrypt("");
        String password =standardPBEStringEncryptor.encrypt("");
        /*将加密的文本写到配置文件中*/
        System.out.println("name="+name);
        System.out.println("password="+password);
    }

}
