package shaohua.study.proxy.jdkproxy.staticproxy;

import shaohua.study.proxy.jdkproxy.Person;

import java.lang.reflect.InvocationTargetException;

/**
 * 功能描述: 相比StuProxy，这里加入了统一处理中心CallCenter，所有逻辑可以在里面处理
 *
 * JDK 动态代理，即是生成了StuProxy1这个类
 * @author Liush
 * @date 2018/05/08 18:39
 */
public class StuProxy1 implements Person {
    private CallCenter callCenter;
    public StuProxy1(CallCenter callCenter){
        this.callCenter = callCenter;
    }
    @Override
    public void sayHello() {
        try {
            callCenter.invoke(Person.class.getMethod("sayHello"),null);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sayHi() {

    }
}
