package shaohua.study.JVM;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/05 11:31
 */
public class JavaVirtualMachineStackTest {
    public static void main(String[] args) throws InterruptedException {
        final A a = new A();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                System.out.println(a.a.get());
            }
        });
        //========== 单线程 ===========
        //====== 固定大小====-Xss256k
        //a.f(); //2271
        //a.f(1);//1993
        //a.f(1,1,1.0); //1669
        //a.f1();//1901
        //a.f2();//1667


        //=======不固定大小===
        a.f(); //9835
        //a.f(1);//9047
        //a.f(1,1,1.0);//7451

        //a.f1();//9525
        //a.f2();//9069

        //==========多线程===========
        //====== 固定大小====-Xss256k
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                a.f();//4937
//            }
//        };
//        Thread t = new Thread(r);
//        Thread t2 = new Thread(r);
//        t.start();
//        t2.start();
//        t.join();
//        t2.join();
    }
}
class A{
    AtomicInteger a = new AtomicInteger(0);
    public void f(){
        try {Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
        a.incrementAndGet();
        f();
    }

    public void f(long l){
        a.incrementAndGet();
        f(l);
    }
    public void f(long l,int i, double d){
        a.incrementAndGet();
        f(l,i,d);
    }

    public void f1(){
        {long d = 0, e = 0;}
        long r = 0, m = 0;
        a.incrementAndGet();
        f1();
    }
    public void f2(){
        long d = 0, e = 0, r = 0, m = 0;
        a.incrementAndGet();
        f2();
    }

}
