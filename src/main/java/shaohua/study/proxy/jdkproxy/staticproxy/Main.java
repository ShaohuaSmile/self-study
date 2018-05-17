package shaohua.study.proxy.jdkproxy.staticproxy;

import shaohua.study.proxy.jdkproxy.Person;
import shaohua.study.proxy.jdkproxy.Student;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/05/08 18:46
 */
public class Main {
    public static void main(String... args){
        Person person = new Student();
        CallCenter callCenter = new CallCenter(person);
        Person personProxy = new StuProxy1(callCenter);
        personProxy.sayHello();
    }

}
