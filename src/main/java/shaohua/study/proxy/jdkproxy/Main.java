package shaohua.study.proxy.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/05/08 16:58
 */
public class Main {
    public static void main(String... args){
        Person stu = new Student();
        InvocationHandler handler = new StuInvocationHandler(stu);
        Person person = (Person) Proxy.newProxyInstance(Main.class.getClassLoader(),new Class[]{Person.class},handler);
        person.sayHello();
        person.sayHi();
        System.out.println(person.getClass().getName());

        Person person1 = (Person) Proxy.newProxyInstance(Main.class.getClassLoader(),new Class[]{Person.class},handler);
        person1.sayHello();
        person1.sayHi();
        System.out.println(person1.getClass().getName());

        byte[] bytes = ProxyGenerator.generateProxyClass("&Proxy0",new Class[]{Person.class});
        try {
            FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\$Proxy0.class"));
            outputStream.write(bytes);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

