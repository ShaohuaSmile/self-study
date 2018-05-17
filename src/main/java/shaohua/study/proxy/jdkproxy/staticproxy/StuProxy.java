package shaohua.study.proxy.jdkproxy.staticproxy;


import shaohua.study.proxy.jdkproxy.Person;
import shaohua.study.proxy.jdkproxy.Student;

/**
 * 功能描述: 静态代理 记录方法执行时间
 *  手动每个方法都添加，假如这里有50分方法，重复工作量大
 *  如果能集中处理是不是很好？集中调一个方法，里面处理附加逻辑，然后根据入参调目标方法
 * @author Liush
 * @date 2018/05/08 18:17
 */
public class StuProxy implements Person {
    private Student stu;
    public StuProxy(Student stu){
        this.stu = stu;
    }
    @Override
    public void sayHello() {
        long b = System.currentTimeMillis();
        stu.sayHello();
        long e = System.currentTimeMillis();
        System.out.println(e-b);
    }

    @Override
    public void sayHi() {
        long b = System.currentTimeMillis();
        stu.sayHi();
        long e = System.currentTimeMillis();
        System.out.println(e-b);
    }
}
