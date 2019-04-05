package jdk.time;

import java.time.Instant;

/**
 * Date => Instant Unix时间戳
 * Calendar => LocalDateTime 日期
 * Calander
 *
 * @author Ville
 * @date 2019/2/28
 */
public class TimeTest {
    public static void main(String[] args) {
        //格式时间戳 2019-03-19 14:22:14.736
//        System.out.println(Timestamp.from(Instant.now()));
//        System.out.println(Timestamp.valueOf(LocalDateTime.now()));
        System.out.println(Instant.now());
        //Unix时间戳 1552976534
//        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
//        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8)));
//        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(Instant.now().getEpochSecond());
        //13位毫秒值
//        System.out.println(Instant.now().toEpochMilli());
        System.out.println(System.currentTimeMillis());
    }
}
