package shaohua.study.spring.simpleSpring.ioc.beans;

/**
 * 功能描述: 定义bean相关信息
 *
 * @author Liush
 * @date 2017/11/08 10:06
 */
public class BeanDefinition {
    private String beanClassName;
    private Class beanClass;
    private Object bean;

    private PropertyValues propertyValues;

    public BeanDefinition(){}
    public BeanDefinition(Object bean){
        this.bean = bean;
    }
    public Object getBean(){
        return bean;
    }
    public void setBean(Object bean){
        this.bean = bean;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) throws ClassNotFoundException {
        this.beanClassName = beanClassName;
        Class clazz = Class.forName(beanClassName);
        this.beanClass = clazz;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
        this.beanClassName = beanClass.getName();
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
