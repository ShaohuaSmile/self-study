package shaohua.study.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2019/01/22 20:57
 */
public class Interupte {
    public static void main(String ... args) throws InterruptedException {
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
////                    try {
////                        Thread.sleep(500);
////                    } catch (InterruptedException e) {
////                        System.out.println("---InterruptedException-----");
////                        e.printStackTrace();
////                       // throw new RuntimeException("pppppppppp");
////                    }
//                    Thread.currentThread().interrupt();
//                    System.out.println("--------");
//                }
//            }
//        });
//        t.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.out.println("---InterruptedException-----");
//            e.printStackTrace();
//        }
//        t.interrupt();

        ExecutorService es = Executors.newFixedThreadPool(5);
        Future future = es.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                while (true){
                   // Thread.sleep(100);
                    System.out.println("---");
                    if(1==2){
                        break;
                    }
                }
                return null;
            }
        });
        Thread.sleep(500);
        System.out.println("--gggggggggggggggggggggggggggggggggg-");
        future.cancel(true);
    }


}
