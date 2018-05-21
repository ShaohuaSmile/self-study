package shaohua.study.spring.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 功能描述: Advisor 定义； spring bean xml 配置示例
 *
 * @author Liush
 * @date 2018/05/21 10:20
 */
public class TimeHelper implements MethodBeforeAdvice, AfterReturningAdvice{
    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        threadLocal.set(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        long begin = threadLocal.get();
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("cost:" + (end-begin));
    }
}
