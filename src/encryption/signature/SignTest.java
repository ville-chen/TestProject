package encryption.signature;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Ville
 * @date 2018/9/26
 */
public class SignTest {
    public static void main(String[] args) throws Exception {
        //String url = "http://testm.outdoorclub.com.cn/api/groupActivity/category?appId=xingzhuang&sign=3FA4CCF5193BC4ED68B9A9443E75D547&timestamp=1537937827141";
        /*String url = "http://testm.outdoorclub.com.cn/api/redrain/over?appId=xingzhuang&timestamp=1540620749663&sign=D34C2529C60CFC9F87386F7BFF9B6EAB";
        Map<String, String> paramMap = new HashMap<>(8);
        paramMap.put("appId", "xingzhuang");
        paramMap.put("timestamp", "1540620749663");
        paramMap.put("sign", "D34C2529C60CFC9F87386F7BFF9B6EAB");
        System.out.println(test("/api/redrain/over", paramMap, "D34C2529C60CFC9F87386F7BFF9B6EAB"));*/

        encryptStr("");
    }

    static boolean test(String url, Map<String, String> parameterMap, String sign) throws Exception {
        Iterator iterator = parameterMap.keySet().iterator();
        SignUtils su = new SignUtils();
        su.setUrl(url);
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (!("sign".equals(key))) {
                String value = parameterMap.get(key);
                su.put(key, value);
            }
        }
        String backSign = su.getSign();
        if (!sign.equals(backSign)) {
            System.out.println(String.format("签名校验失败，uri：%s ，参数map：%s ，后台sign值：%s ", url, su.getParamMap(), backSign));
            System.out.println(String.format("加密参数：%s ", su.getEncryptStr()));
            return false;
        }
        return true;
    }

    static void encryptStr(String toEncryptStr) {
        System.out.println(SignUtils.md5Encrypt(toEncryptStr).toUpperCase());
    }
}
