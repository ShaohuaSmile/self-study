package shaohua.study.spring.simpleSpring.ioc.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述: 装bean
 *
 * @author Liush
 * @date 2017/11/08 10:11
 */
public class BeanFactory {
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap();

    /**
     * 功能描述: 获取bean
     *
     * @author Liush
     * @date 2017/11/8
     */
    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 功能描述: 注册bean
     *
     * @author Liush
     * @date 2017/11/8
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
