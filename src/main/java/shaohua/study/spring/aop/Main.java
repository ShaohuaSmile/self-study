package shaohua.study.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/05/21 10:41
 */
public class Main {
    public static void main(String... args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Person person = (Person) context.getBean("manProxy");
        person.eat();
//        Person person1 = (Person) context.getBean(Person.class);
//        person1.eat();
    }
}
