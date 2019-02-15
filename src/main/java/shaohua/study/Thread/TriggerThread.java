package shaohua.study.Thread;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/02/02 17:03
 */
public class TriggerThread implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            Outprinter.print(i+"");
        }
        synchronized (Outprinter.class){
            Outprinter.class.notifyAll();
        }
        synchronized (Main.class){
            Main.class.notifyAll();
            System.out.println("=======notifyAll=======");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=======run end=======");
    }
}
