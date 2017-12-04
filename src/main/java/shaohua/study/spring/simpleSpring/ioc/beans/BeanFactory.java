package shaohua.study.spring.simpleSpring.ioc.beans;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/08 10:54
 */
public interface BeanFactory {

    Object getBean(String name) throws IllegalAccessException, NoSuchFieldException, InstantiationException;


    void registerBeanDefinition(String name,BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException, NoSuchFieldException;
}
