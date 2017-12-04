package shaohua.study.spring.simpleSpring.ioc;

import shaohua.study.spring.MessageService;
import shaohua.study.spring.simpleSpring.ioc.Reader.AnnotationBeanDefinitionReader;
import shaohua.study.spring.simpleSpring.ioc.Reader.BeanDefinitionReader;
import shaohua.study.spring.simpleSpring.ioc.beans.*;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/08 10:09
 */
public class IocTest {

    public static void main(String... args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, IOException {
        /************************************  1  *********************/
//        /*
//         * 定义并注册bean
//         */
//        SimpleClass inst = new SimpleClass();
//        BeanDefinition beanDefinition = new BeanDefinition(inst);
//        BeanFactory beanFactory = new BeanFactory();
//        beanFactory.registerBeanDefinition("simpleClass",beanDefinition);
//
//        /*
//         * 获取bean
//         */
//        SimpleClass simpleInst = (SimpleClass)beanFactory.getBean("simpleClass");
//        simpleInst.doing();

        /**********************************   2  *************************/
        //接口化，Factory创建bean
//        BeanDefinition beanDefinition = new BeanDefinition();
//        beanDefinition.setBeanClassName("shaohua.study.spring.simpleSpring.ioc.SimpleClass");
//        BeanFactory beanFactory = new AutoCreateBeanFactory();
//        beanFactory.registerBeanDefinition("simpleClass",beanDefinition);
//
//        SimpleClass simpleInst = (SimpleClass) beanFactory.getBean("simpleClass");
//        simpleInst.doing();

        /**********************************   3  *************************/
//        //为实例设置属性
//        BeanDefinition beanDefinition = new BeanDefinition();
//
//        PropertyValues propertyValues = new PropertyValues();
//        PropertyValue propertyValue = new PropertyValue("name","Shaohua");
//        PropertyValue propertyValue3 = new PropertyValue("name","Shaohua2");
//        PropertyValue propertyValue2 = new PropertyValue("age",18);
//        propertyValues.addPropertyValue(propertyValue);
//        propertyValues.addPropertyValue(propertyValue2);
//        propertyValues.addPropertyValue(propertyValue3);
//        beanDefinition.setPropertyValues(propertyValues);
//
//        beanDefinition.setBeanClassName("shaohua.study.spring.simpleSpring.ioc.SimpleClass");
//        BeanFactory beanFactory = new AutoCreateBeanFactory();
//        beanFactory.registerBeanDefinition("simpleClass",beanDefinition);
//
//        SimpleClass simpleInst = (SimpleClass) beanFactory.getBean("simpleClass");
//        simpleInst.doing();

        /**********************************  4  *************************/
//        //自动扫描包下Service类
//        BeanFactory factory = new AutoCreateBeanFactory();
//
//        AnnotationBeanDefinitionReader reader = new AnnotationBeanDefinitionReader();
//        reader.loadBeanDefinitions("shaohua.study.spring.simpleSpring");
//        for(Map.Entry<String,BeanDefinition> entry:reader.getRegistry().entrySet()){
//            factory.registerBeanDefinition(entry.getKey(),entry.getValue());
//        }
//
//        SimpleClass simpleInst = (SimpleClass) factory.getBean("simpleClass");
//        simpleInst.doing();
        /**********************************   5  *************************/
//        //获取实例并依赖注入
        BeanFactory factory = new AutoCreateBeanFactory();
        AnnotationBeanDefinitionReader reader = new AnnotationBeanDefinitionReader();
        reader.loadBeanDefinitions("shaohua.study.spring");
        for(Map.Entry<String,BeanDefinition> entry:reader.getRegistry().entrySet()){
            factory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }

        InjectionService injectionService = (InjectionService) factory.getBean("injectionService");
        injectionService.hello();

    }
}
