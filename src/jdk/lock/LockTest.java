package jdk.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ville
 * @date 2019/1/3
 */
public class LockTest {
    public static int count = 0;
    public static AtomicInteger acount = new AtomicInteger();

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000000; j++) {
                    synchronized (LockTest.class) {
                        count++;
                        //acount.incrementAndGet();
                    }
                }
            }
            ).start();
        }
        while (true) {
            if (count == 100000000)
                break;
        }
        long end = System.currentTimeMillis();
        System.out.println("用时毫秒：" + (end - begin));
        System.out.println("count=" + count);
        System.out.println("acount=" + acount.get());
    }

}
