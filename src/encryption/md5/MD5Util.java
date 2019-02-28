package encryption.md5;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5摘要算法
 */
public class MD5Util {

    public static void main(String[] args) {
        String source = "Znws123456";
        System.out.println(md5(source));
//        System.out.println(string2MD5(source));
    }

    /**
     * 字符串 => 32位md5值 (升级版)
     */
    public static String md5(String source) {
        if (null == source) {
            return null;
        }
        byte[] bytes = source.getBytes(StandardCharsets.UTF_8);
        StringBuilder builder;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(bytes);
            builder = new StringBuilder(32);
            //每个字节 => 两位十六进制（其中小于16的，第一位十六进制补0）
            for (byte b : md5Bytes) {
                //按位或 0x100 （1 0000 0000），保证值小于16的字节的二进制为9位，这样转成十六进制时只要截取后两位即可
                builder.append(Integer.toHexString(b & 0xFF | 0x100), 1, 3);
            }
        } catch (Exception e) {
            System.out.println("Can not encode the string '" + source + "' to MD5! cause by :" + e.getMessage());
            return null;
        }
        return builder.toString();
    }

    /**
     * 字符串 => 32位md5值 (原理版)
     */
    public static String string2MD5(String source) {
        if (null == source) {
            return null;
        }
        //转字符
        char[] chars = source.toCharArray();
        //转ascii值
        byte[] bytes = new byte[chars.length];
        for (int i = 0; i < chars.length; i++)
            bytes[i] = (byte) chars[i];
        //获取摘要工具
        MessageDigest md5;
        try {
            //将ascii数组摘要为长度16的字节数组
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Can not encode the string '" + source + "' to MD5! cause by :" + e.getMessage());
            return null;
        }
        byte[] md5Bytes = md5.digest(bytes);
        StringBuilder builder = new StringBuilder(32);
        //1位10进制 => 2位16进制
        for (byte b : md5Bytes) {
            //与8个1按位与 => 正值不变，负值取8位变正值
            int val = b & 0xff;
            //值小于16，即转成16制的位数为1位，需要前面补0，保证两位十六进制
            if (val < 16)
                builder.append("0");
            builder.append(Integer.toHexString(val));
        }
        return builder.toString();
    }


}
