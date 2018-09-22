package jdk.general;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by admin on 2017/4/18.
 * 自定义timestamp格式
 */
public class TimeStampDIY {

    public static void main(String[] args) {
        /*DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        //要转换字符串 str_test
        String str_test = null;
        try {
            Timestamp ts = new Timestamp(format.parse(str_test).getTime());
            System.out.println(ts.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        //java8
        LocalDateTime dateTime = LocalDateTime.now();
        String nowDataTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
        String now40Plus = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime.plusYears(40));
        System.out.println(nowDataTime);
        System.out.println(now40Plus);

        System.out.println(BigDecimal.valueOf(0.00).compareTo(BigDecimal.valueOf(1)));

    }

}
