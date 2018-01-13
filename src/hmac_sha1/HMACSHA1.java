package hmac_sha1;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by admin on 2018/1/13.
 */
public class HMACSHA1 {
    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    /**
     * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
     * @param encryptText 被签名的字符串
     * @param encryptKey  密钥
     */
    public static String HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {
        // 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(encryptKey.getBytes(ENCODING), MAC_NAME);
        // 生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(MAC_NAME);
        // 用给定密钥初始化 Mac 对象
        mac.init(secretKey);
        // 完成 Mac 操作
        byte[] digest = mac.doFinal(encryptText.getBytes(ENCODING));
        StringBuilder builder = new StringBuilder();
        for (byte b : digest) {
            String hexStr = String.format("%02x", b);
            builder.append(hexStr);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str1 = "param2/1/system/currentTime/1000000a1b2";
        String str2 = "test123";
        String str3 = "33e54f4f7b989e3e0e912d3fbd2f1a03ca7cce88";
        try {
            String str = HmacSHA1Encrypt(str1, str2);
            System.out.println(str.equalsIgnoreCase("33e54f4f7b989e3e0e912d3fbd2f1a03ca7cce88"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
