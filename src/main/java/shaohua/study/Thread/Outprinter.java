package shaohua.study.Thread;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/02/02 16:55
 */
public class Outprinter{
    public static synchronized void  print(String str){
            System.out.println(str+"  --" + Thread.currentThread().getName());
        Outprinter.class.notify();
        try {
            Outprinter.class.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
