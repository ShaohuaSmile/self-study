package shaohua.study.spring.simpleSpring.ioc.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述: 装bean
 *
 * @author Liush
 * @date 2017/11/08 10:11
 */
public abstract class AbstractBeanFactory implements BeanFactory{
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap();

    /**
     * 功能描述: 获取bean
     *
     * @author Liush
     * @date 2017/11/8
     */
    @Override
    public Object getBean(String name) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if(beanDefinition == null){
            throw new RuntimeException("No such bean with name "+name);
        }
        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    /**
     * 功能描述: 注册bean
     *
     * @author Liush
     * @date 2017/11/8
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        beanDefinitionMap.put(name,beanDefinition);
    }

    /**
     * 功能描述: 创建bean
     *
     * @author Liush
     * @date 2017/11/8
     */
    public abstract Object doCreateBean(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException, NoSuchFieldException;

    /**
     * 功能描述: 复制
     *
     * @author Liush
     * @date 2017/11/8
     */
    public abstract void applyProperties(BeanDefinition beanDefinition) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
}
