package shaohua.study.proxy.jdkproxy.staticproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/05/08 18:36
 */
public class CallCenter {
    private Object target;
    public CallCenter(Object target){
        this.target = target;
    }
    public Object invoke(Method method, Class[] args) throws InvocationTargetException, IllegalAccessException {
        long b = System.currentTimeMillis();
        Object result = method.invoke(target,args);
        long e = System.currentTimeMillis();
        System.out.println(e-b);
        return result;
    }
}
