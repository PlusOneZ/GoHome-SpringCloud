package cn.edu.tongji.gohome.login.utils;

import java.util.Random;

/**
 * RandomSmsCodeUtil
 *
 * @author 卓正一
 * @since 2021/12/6 9:04 PM
 */
public class RandomSmsCodeUtil {

    private static final Random randomMachine = new Random();

    public static String getCode() {
        // generate code between 100000 and 999999
        int code = randomMachine.nextInt(899999) + 100000;
        return "" + code;
    }

}
