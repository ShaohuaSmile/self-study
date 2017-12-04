package shaohua.study.spring.simpleSpring.ioc.beans;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/08 11:28
 */
public class PropertyValues {

    private Set<PropertyValue> propertyValues = new HashSet<PropertyValue>();

    public void addPropertyValue(PropertyValue pv){
        propertyValues.add(pv);
    }
    public Set<PropertyValue> getPropertyValues(){
        return propertyValues;
    }
}
