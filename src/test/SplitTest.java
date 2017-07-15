package test;

import java.time.Clock;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 2017/7/13.
 */
public class SplitTest {
    public static void main(String[] args) {
        System.out.println(Calendar.SECOND);
        System.out.println(Instant.now().getEpochSecond() - 8 * 60 * 60 + "000");
        System.out.println(new Date().getTime() / 1000 - 8 * 60 * 60 + "000");
        System.out.println(Clock.systemUTC().millis());

    }
}
