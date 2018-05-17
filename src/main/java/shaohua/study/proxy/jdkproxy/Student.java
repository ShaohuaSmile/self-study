package shaohua.study.proxy.jdkproxy;

import shaohua.study.annotation.ServiceId;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/05/08 15:57
 */
@ServiceId
public class Student implements Person {
    @Override
    public void sayHello() {
        System.out.println("Hello, from stu....");
    }

    @Override
    public void sayHi() {
        System.out.println("Hi, from stu....");
    }
}
