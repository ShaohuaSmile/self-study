package shaohua.study.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//最终的代理类
class Proxy0 implements Person{
    private InvocationHandler invocationHandler;
    private Method sayHello = Person.class.getMethod("sayHello");
    private Method sayHi = Person.class.getMethod("sayHi");
    public Proxy0(InvocationHandler invocationHandler) throws NoSuchMethodException {
        this.invocationHandler = invocationHandler;
    }
    @Override
    public void sayHello() {
        try {
            invocationHandler.invoke(this,sayHello,(Object[])null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    @Override
    public void sayHi() {
        try {
            invocationHandler.invoke(this,sayHi,(Object[])null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
