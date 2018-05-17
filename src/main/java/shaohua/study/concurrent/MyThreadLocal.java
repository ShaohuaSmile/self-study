package shaohua.study.concurrent;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/08 10:01
 */
public class MyThreadLocal<T> {
    public T get(){
        Thread thread = Thread.currentThread();
        if(thread instanceof MyThread){
            MyThread myThread = (MyThread) thread;
            Map<MyThreadLocal,Object> threadLocalMap =  myThread.threadLocalMap;
            if(threadLocalMap == null){
                threadLocalMap = new WeakHashMap<MyThreadLocal, Object>();
                myThread.threadLocalMap = threadLocalMap;
            }
            return (T) threadLocalMap.get(this);
        }
        throw new RuntimeException("MyThreadLocal is used to MyThread only!");
    }

    public void set(T t){
        Thread thread = Thread.currentThread();
        if(thread instanceof MyThread){
            MyThread myThread = (MyThread) thread;
            Map<MyThreadLocal,Object> threadLocalMap =  myThread.threadLocalMap;
            if(threadLocalMap == null){
                threadLocalMap = new WeakHashMap<MyThreadLocal, Object>();
                myThread.threadLocalMap = threadLocalMap;
            }
           threadLocalMap.put(this,t);
            return;
        }
        throw new RuntimeException("MyThreadLocal is used to MyThread only!");
    }
}
