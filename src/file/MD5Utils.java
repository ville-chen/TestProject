package file;

import java.security.MessageDigest;

/**
 * Created by admin on 2017/7/5.
 */
public class MD5Utils {

    public static void main(String[] args) {
        String source = "71LX404862404CN12345ABCDE";
        System.out.println(md5(source));
    }

    public static String md5(String source) {

        StringBuffer sb = new StringBuffer(32);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(source.getBytes("utf-8"));
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
                //String.format("%02x",array[i]);
            }
        } catch (Exception e) {
            System.out.println("Can not encode the string '" + source + "' to MD5! cause by :" + e.getMessage());
            return null;
        }
        return sb.toString();
    }
}
