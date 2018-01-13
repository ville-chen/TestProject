package programming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/12/6.
 */
public class Test {

    public static void main(String[] args) {
       /* SerializeConfig cfg=new SerializeConfig();
        cfg.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd'T'HH:mm:ss"));

        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        String jsonString = JSON.toJSONString(dateFromBase);
        Date date = JSON.parseObject(jsonString, Date.class);
        System.out.println(date);*/

        /*String source = "3135&jlj-lsifje";
        String[] split = source.split("[&-]");
        System.out.println(Arrays.toString(split));*/

        String skuIds = ",";
        List<String> skuIdList = Arrays.asList(skuIds.split(","));
    }
}
