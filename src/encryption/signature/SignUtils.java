package encryption.signature;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Logger;

/**
 * 获取签名
 *
 * @author Administrator
 */
public class SignUtils {
    /**
     * 定义字符串缓冲区，用于缓冲生成签名数据
     */
    private StringBuffer builder = new StringBuffer();
    private TreeMap<String, String> map = new TreeMap<>();
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    private String newSign = null;

    /**
     * 将用于计算签名的参数名及值以字符串的形式放入treemap
     *
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        map.put(key, value);
    }

    public Map<String, String> getParamMap() {
        return map;
    }

    public String getEncryptStr() {
        return builder.toString();
    }

    /**
     * 获取签名，该方法用于生成前端app请求的签名
     */
    public String getSign() throws Exception {
        //params key 排序
        TreeSet<String> sortedKeySet = new TreeSet<>(map.keySet());
        if (newSign == null) {
            builder.append(url).append("?");
            for (String key : sortedKeySet) {
                builder.append(key).append("=").append(map.get(key)).append("&");
            }
            builder.append("key=").append("xingzhuang-journey-app");
            newSign = md5Encrypt(builder.toString()).toUpperCase();
        }
        return newSign;
    }


    /**
     * 获取测试签名，该方法用于生成前端app请求的签名
     *
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public String getTestSign() throws Exception {
        if (newSign == null) {
//            addObjProperties();
            builder.append(url + "?");
            for (Map.Entry<String, String> en : map.entrySet()) {
                builder.append(en.getKey() + "=" + en.getValue() + "&");
            }
            //添加从secure.properties获取的秘钥
            builder.append("key=" + "xingzhuang-journey-app");
            newSign = md5Encrypt(builder.toString()).toUpperCase();
        }
        return newSign;
    }

    public static String md5Encrypt(String content) {
        Logger logger = Logger.getLogger("webLog");
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(content.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                int number = b & 0xff;//
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(str);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return "";
        } finally {
        }

    }
}
