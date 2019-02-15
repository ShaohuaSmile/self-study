package shaohua.study.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/05/08 16:00
 */
public class StuInvocationHandler implements InvocationHandler {
    private Object student;
    public StuInvocationHandler(Object stu){
        this.student = stu;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //todo proxy logic here
        Object result = method.invoke(student,args);
        //todo proxy logic here
        return result;
    }
}
