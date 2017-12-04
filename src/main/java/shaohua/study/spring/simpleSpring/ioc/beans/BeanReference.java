package shaohua.study.spring.simpleSpring.ioc.beans;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/10 14:35
 */
public class BeanReference {
    private String name;

    public BeanReference(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
