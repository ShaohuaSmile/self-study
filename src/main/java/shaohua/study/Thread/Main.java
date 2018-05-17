package shaohua.study.Thread;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/02/02 17:01
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new TriggerThread(),"t1");
        Thread t2 = new Thread(new TriggerThread(),"t2");
        t1.start();
        t2.start();
    }
}
