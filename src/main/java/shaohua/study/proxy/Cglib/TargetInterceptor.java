package shaohua.study.proxy.Cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 功能描述: 拦截方法统一处理类； 类似 JDK Proxy InvocationHandler
 *
 * @author Liush
 * @date 2018/05/16 15:32
 */
public class TargetInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if("sayHello".equals(method.getName())){
            System.out.println("----ju gong-----");
        }else{
            System.out.println("----smile-----");
        }
        //Object result = method.invoke(o,objects);
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("----yao shou-----");
        return result;
    }
}
