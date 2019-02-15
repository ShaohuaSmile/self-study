package shaohua.study.Thread;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2019/01/14 14:56
 */
public class ThreadPool {
    static volatile AtomicInteger sum = new AtomicInteger();
    public static void main(String[] args) {
        final CountDownLatch counter = new CountDownLatch(10);
        ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Runnable body = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-- sum=" + (sum.incrementAndGet()));
                counter.countDown();
            }
        };

        for(int i=0; i<10; i++){
            es.execute(body);
        }
        try {
            counter.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdown();
        System.out.println("sum:"+sum.get());
    }
}
