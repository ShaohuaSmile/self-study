package shaohua.study.reflect;/**
 * Created by Administrator on 2017/7/16.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/7/16
 */
public class TestMain {
    public static void main(String... args){
        // testProxy();
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            if(inetAddress != null){
                System.out.print(inetAddress.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    private static void testProxy(){
        ServiceProxy processor = new ServiceProxy();
        processor.proxy(new ServiceImpl());
        Service proxy = (Service) Proxy.newProxyInstance(ServiceImpl.class.getClassLoader(),ServiceImpl.class.getInterfaces(),processor);
        proxy.print("zangsan");
    }
    private static void testReflect(){
        try {
            Class _service = Class.forName("shaohua.study.reflect.ServiceImpl");
            try {
                Method method = _service.getMethod("print",String.class);
                try {
                    method.invoke(_service.newInstance(),"niubi");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
