package jdk.time;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author Ville
 * @date 2019/2/28
 */
public class TimeTest {
    public static void main(String[] args) {
        //时间戳
//        System.out.println(Instant.now());
//        System.out.println(Timestamp.from(Instant.now()));
        System.out.println(Timestamp.valueOf(LocalDateTime.now()));
        //毫秒值
//        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
//        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(Instant.now().getEpochSecond());
    }
}
