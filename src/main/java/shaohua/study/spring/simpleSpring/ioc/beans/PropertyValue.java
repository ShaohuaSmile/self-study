package shaohua.study.spring.simpleSpring.ioc.beans;

import org.apache.commons.lang3.StringUtils;

/**
 * 功能描述: bean属性配置信息
 *
 * @author Liush
 * @date 2017/11/08 11:27
 */
public class PropertyValue {
    private String name;
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int hashCode(){
        return name.hashCode();
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        return obj instanceof PropertyValue && this.name.equals(((PropertyValue) obj).getName());
    }

}
