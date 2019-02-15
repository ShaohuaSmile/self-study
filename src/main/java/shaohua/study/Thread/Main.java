package shaohua.study.Thread;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/02/02 17:01
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //线程交替执行
        Thread t1 = new Thread(new TriggerThread(),"t1");
        Thread t2 = new Thread(new TriggerThread(),"t2");
        t1.start();
        t2.start();

        //等待执行完了再执行
        System.out.println("执行中");
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        if(t1.isAlive()){
            synchronized (Main.class){
                System.out.println("======== t1 wait begin ===========");
                Main.class.wait();
                Thread.sleep(1000);
                System.out.println("======== t1 wait end ===========");
            }
        }
        if(t2.isAlive()){
            synchronized (t2){
                t2.wait();
            }
        }
        System.out.println("执行完了");

    }
}
