package encryption.aes;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * AES加密算法工具类
 */
public class AESUtil {

    /**
     * AES加密方法
     */
    public static byte[] encrypt(String original, String seedStr) {
        if (null == original || "".equals(original)) {
            return null;
        }
        if (null == seedStr || "".equals(seedStr)) {
            return null;
        }
        Cipher cipher = getCipher(seedStr, Cipher.ENCRYPT_MODE);
        if (null == cipher) {
            return null;
        }
        byte[] originalByteArray = original.getBytes(StandardCharsets.UTF_8);
        try {
            //返回一个固定长度为16的字节数组
            return cipher.doFinal(originalByteArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 10进制字节数组（密文） => 16进制字符串（密文）
     */
    public static String byte2HexStr(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            hex = hex.length() == 1 ? String.format("0%s", hex) : hex;
            builder.append(hex.toUpperCase());
        }
        return builder.toString();
    }

    /**
     * 16进制字符串（密文） => 10进制字节数组（密文）
     */
    public static byte[] hexStr2Byte(String hexStr) {
        if (hexStr.length() != 32)
            return null;
        byte[] bytes = new byte[16];
        for (int i = 0; i < 16; i++) {
            //每两位16进制是由一个十进制字节转化而来
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            bytes[i] = (byte) (high * 16 + low);
        }
        return bytes;
    }

    /**
     * AES解密方法
     */
    public static byte[] decrypt(byte[] encryptedByteArray, String seedStr) {
        if (null == encryptedByteArray || 16 != encryptedByteArray.length) {
            return null;
        }
        if (null == seedStr || "".equals(seedStr)) {
            return null;
        }
        Cipher cipher = getCipher(seedStr, Cipher.DECRYPT_MODE);
        if (null == cipher) {
            return null;
        }
        try {
            //返回原文的字节数组
            return cipher.doFinal(encryptedByteArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 获取暗号生成器
     */
    private static Cipher getCipher(String seedStr, int encryptMode) {
        Cipher cipher = null;
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(seedStr.getBytes());
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] encodedByteArray = secretKey.getEncoded();
            SecretKeySpec sks = new SecretKeySpec(encodedByteArray, "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(encryptMode, sks);
            return cipher;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return cipher;
        }
    }

    public static void main(String[] args) {

    }

    private static void crack(String encryptedStr) {
        String seedStr = "journey-admin-password";
        byte[] encryptedBytes = hexStr2Byte(encryptedStr);
        byte[] decryptedBytes = decrypt(encryptedBytes, seedStr);
        if (null != decryptedBytes) {
            String original = new String(decryptedBytes, StandardCharsets.UTF_8);
            System.out.println(", " + original);
        }
    }
}
