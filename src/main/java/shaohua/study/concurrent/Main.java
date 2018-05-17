package shaohua.study.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/08 10:16
 */
public class Main {
    private static MyThreadLocal<Integer> myThreadLocal = new MyThreadLocal<Integer>();

    public static void main(String[] args) {
        final MyThread myThread = new MyThread(new Runnable(){
            @Override
            public void run() {
                myThreadLocal.set(74657);
                System.out.println(myThreadLocal.get());
            }
        });
        final MyThread myThread2 = new MyThread(new Runnable(){
            @Override
            public void run() {
                //myThreadLocal.set("gggggggggggg");
                System.out.println(myThreadLocal.get());
            }
        });
//        myThread.start();
//        myThread2.start();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 1000; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Integer count = myThreadLocal.get();
                    if(count == null){
                        myThreadLocal.set(1);
                    }else {
                        myThreadLocal.set(count + 1);
                    }
                    System.out.println("======"+Thread.currentThread().getName()+"======"+count);
                }
            });
        }
    }
}
