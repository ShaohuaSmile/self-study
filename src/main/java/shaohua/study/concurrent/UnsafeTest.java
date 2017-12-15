package shaohua.study.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/11 18:56
 */
public class UnsafeTest {
    private static sun.misc.Unsafe unsafe; // = Unsafe.getUnsafe(); throw new SecurityException("Unsafe");
    private volatile int value;
    private static final long offset;
    static{
        try {
            Class unsageClass = Class.forName("sun.misc.Unsafe");
            Constructor constructor = unsageClass.getDeclaredConstructor(new Class[]{});
            constructor.setAccessible(true);
            unsafe = (Unsafe) constructor.newInstance(new Class[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            offset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
    public UnsafeTest(int value){
        this.value = value;
    }
    public void increment(){
        ++value;
        /*  value = value + 1;
         * 1 读取value
         * 2 加1
         * 3 回写value
         */
    }
    public void casIncrement(){
        //unsafe.getAndAddInt(this,offset,1);;
        //boolean failSwap = false;
        for(;;){
            int temp = unsafe.getIntVolatile(this,offset);
            int after = temp + 1;
            if(unsafe.compareAndSwapInt(this,offset,temp,after)){
               return;
            }
        }
    }

    public static void main(String... args) throws InterruptedException {
        final int[] a = {0};
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final UnsafeTest test = new UnsafeTest(a[0]);
        int threads = 4;
        ExecutorService es = Executors.newFixedThreadPool(threads);
        final CountDownLatch downLatch = new CountDownLatch(threads);
        for(int i = 0; i < threads; i++){
            es.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        for(int i = 0; i < 100000; i++){
                            //a[0]++;
                            test.increment();
                          //  test.casIncrement();
                            //atomicInteger.getAndIncrement();
                        }
                    }finally{
                        System.out.println("count down");
                        downLatch.countDown();
                    }
                }
            });
        }
        downLatch.await();
        Thread.sleep(100);
        es.shutdown();
        System.out.println(a[0]);
        System.out.println(test.value);
        System.out.println(atomicInteger);
    }
}
