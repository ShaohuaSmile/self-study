package shaohua.study.proxy.Cglib;

import org.springframework.cglib.core.GeneratorStrategy;
import org.springframework.cglib.proxy.Enhancer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/05/16 15:38
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        TargetInterceptor interceptor = new TargetInterceptor();
        enhancer.setCallback(interceptor);
        Student student = (Student) enhancer.create();
        student.sayHello();
        student.sayHi();

        Class enhancerClass = enhancer.getClass().getSuperclass();
        Field strategyField = enhancerClass.getDeclaredField("strategy");
        strategyField.setAccessible(true);
        GeneratorStrategy generatorStrategy = (GeneratorStrategy) strategyField.get(enhancer);
        byte[] bytes = generatorStrategy.generate(enhancer);
        File file = new File("C:\\Users\\Administrator\\Desktop\\enhancerClass.class");
        OutputStream os = new FileOutputStream(file);
        os.write(bytes);
        os.flush();
    }
}
