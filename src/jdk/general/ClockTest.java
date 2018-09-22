package jdk.general;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by admin on 2017/4/14.
 */
public class ClockTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        DateTimeFormatter dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        String now1 = ZonedDateTime.now().format(dtf);
        System.out.println(now1);
        String right = now1.substring(now1.indexOf("+"));
        String left = now1.substring(0,now1.indexOf("."));
        System.out.println(left + right);

        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
    }
}
