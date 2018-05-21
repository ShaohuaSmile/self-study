package shaohua.study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 功能描述: Advisor 定义 @Aspect 注解方式示例
 *
 * @author Liush
 * @date 2018/05/21 11:41
 */
@Aspect
public class LogHelper {
    @Pointcut("execution(public * shaohua.study.spring.aop.*.*(..))")
    public void log(){}
    @Before("log()")
    public void before(){

    }
    @After("log()")
    public void after(){

    }
    @Around("log()")
    public void around(ProceedingJoinPoint pjd) throws Throwable {
        Signature signature = pjd.getSignature();
        String name = signature.getName();
        String className = pjd.getTarget().getClass().getName();
        StringBuilder sb = new StringBuilder();
        sb.append("开始：className=").append(className);
        sb.append(" name=").append(name);
        System.out.println(sb.toString());
        Object obj = pjd.proceed();
        System.out.println("返回："+(obj==null?"":obj));
    }
}
