package shaohua.study.concurrent;

import java.util.Map;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/08 10:01
 */
public class MyThread extends Thread{
    protected Map<MyThreadLocal,Object> threadLocalMap;
    public MyThread(){}
    public MyThread(Runnable runnable){
        super(runnable);
    }
}
