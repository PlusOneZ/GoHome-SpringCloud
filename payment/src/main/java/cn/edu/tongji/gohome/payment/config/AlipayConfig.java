package
        cn.edu.tongji.gohome.payment.config;

/**
 * Config the argument for the Alipay service...
 *
 * @author : loey
 * @className : AlipayConfig
 * @since : 2021-11-24 18:04
 **/
public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2021000118654620";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCIA7poC5JnA3RZJwrss0//Euz8J2KzUBq7lwxihBw4w3X9StZNX7gk2wNH1/+qz2hGpomCDKewHyjCCuZYtZijY2R9epVk64tTMKiw+oWZAOMRY84p+34WW5DgEvHaJImHifQi7gepN7HSV2bAXJpeyz2vS6qTMW1CE62531EYqqUA5Xj2RznJ5H7L/yEQ87ssR3r/CypS3PGeuKjlD7EiYm0Mn1yexYydsEvkav6vSy2/WnLU7yboezIRgNWz0Ly7kfWCkqmT/CzsFEOVgM+y4RiGjg5oGq2U4LkIWGtdCvGDW0gDEc1AiCCOaV3mctkIRMuOSW/NI3ucGjQd3p0VAgMBAAECggEAbpwZi2Ndu8hjZd0KVVO9SoHpl2WwLoKGOuererJVARRzb3jcri+ZYN9624IcuJvTASGN0eTYubGdQ6/5g0qqxrSdlC2MMHYc55o6lTImUzcVcZ7omdubvjLYrmC5rdzouwDFOWK5eDOCuLu7I9Qq9cvybgvqu6kGYSX/sZiaKqPl+laDYabPxVKF5jAIh85MEeU20ghsCO2rzai/nXQ8GE10HNFgBXfEPB/UMA4NQ5Gv2gZgA6v1r2uGn97WClX1Q2nvueCwkpbnlju+DwiqE/uY79XcECXrFEWeCxrCsre1jeh4OayqzuLBUjSfmbmW5wlb/rIXjqUhPiR+af1KQQKBgQDjXb/giO0dQMEArdA765sTBJj4UtPRbe1VIji5PD/TsnS9KEt+CWSRn0dWKlYCd/UWDI/aUtJsO1rvme4Nv8Dh62q+Dw2xNmROisgxwwyIKnToBCKwGES9z4IVqPgWpJK24w1Dt6kpHI1q/wJFFLo9VJbZI4ko+YRX3w9yVoVQowKBgQCZJNDp2lvLoJFqoc4kb43l3iBdq9Xn6ad/600SccQjKQX9dwPhPZMK4kMRx3GbX2HVs5tb+d6pymbISqodwUfiEbacV4rqIcPbZYITxL3wPjs/mEBtRP1isf/KGnkWooQtsBG741NBGOyRLzrluClZhxpfgr0YevLBz5zzDJ1e5wKBgQDCax/v+CYJpZ1j3zz4f/cSxBOqA+lsY/tVmPW4L3TEqQx500L6ez2r5+8wFvOFGN5SBFvd7IRSWE7iI1YUG6vrg0q7SlQC/Oe44aNeKdNFfEiLPT4MJjRhulcZ/mplskRibrSg+yODLA8hNv3R5G98kiCLfH+Eshggq3Sh6KoG0QKBgQCQ9xW/WFDup3cfnjz5ppOG1caDhQa+OiKxZzaU0BZfRhUCgqesjlHjypy8drQm5JpC5XqaDSRmS08SKANymSSHbkcTJZc83Gt/Ak6okeNOSEpjf6b1CIpm46IDWR3ofDxs1y9iUOTdSU+eezvgenzB367qXGLNiozDQ9kJBZbuXwKBgQCE9Y7cX+4Kml0Lp7D2UJKPXZnKkTG6YNzsProCqordVfvUUCyUJFK6N5Ixj7CVZy5o20rZxyT5zmLoXglgMzsv6uBw8zTuiemXXycOyf+lEHMS91/Ajlp6I5HD/YsSgjEqQY+wmvlgUWc5cnU7nUP2gGgaN3IAttTFC6XadswjqA==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjNjukAOdp+XrvGH86p6wheV7BHWqjlWt5Vw3CtVXur7xE+4N/sVoVDKco2YuakY/LHKSqkW1OVIIxw8Prs9foBnU2t4ZomQxoKVwOW8o9b4tjjjjG4Jq34jJB7z1dPYm7YqkGmCMxMegEsPapHxkyI3PIhElQ+9uQ+b2MIfave4Fg49+LK0nqciEMVl8PPjc0M/o/33i19JbV3QG+SPfvxt/NtDlldiMgRNurl6gl954T2bTVbxIMurp97IFbqCbL7LLcwyVgGV40G/qmQXZ2hqn12L62hcn1wFd2t5sO4XSKo20H0w1VAOUgyRlLNE9+9BTUVDl2RmSKXOscuBBaQIDAQAB";

    // 服务器异步通知页面路径
    public static String notify_url = "http://8.131.225.65:8080/api/v1/payment/notify";

    // 页面跳转同步通知页面路径,支付成功显示页面
    public static String return_url = "http://8.131.225.65";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，沙箱环境的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

}