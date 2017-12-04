package shaohua.study.spring.simpleSpring.ioc.beans;

import java.lang.reflect.Field;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/08 11:01
 */
public class AutoCreateBeanFactory extends AbstractBeanFactory {
    /**
     * 功能描述: 创建bean
     *
     * @param beanDefinition
     * @author Liush
     * @date 2017/11/8
     */
    @Override
    public Object doCreateBean(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class beanClass = beanDefinition.getBeanClass();
        Object bean  = beanClass.newInstance();
        beanDefinition.setBean(bean);
        applyProperties(beanDefinition);
        return bean;
    }

    /**
     * 功能描述: 赋值属性
     *
     * @param beanDefinition
     * @author Liush
     * @date 2017/11/8
     */
    @Override
    public void applyProperties(BeanDefinition beanDefinition) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        if(propertyValues != null && propertyValues.getPropertyValues().size() > 0){
            for(PropertyValue propertyValue:propertyValues.getPropertyValues()){
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                Field field = beanDefinition.getBeanClass().getDeclaredField(name);
                if(value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference)value;
                    value = getBean(beanReference.getName());
                }
                field.setAccessible(true);
                field.set(beanDefinition.getBean(),value);
                field.setAccessible(false);
            }
        }
    }
}
