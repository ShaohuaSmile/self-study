package shaohua.study.javaBasic;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/05 16:38
 */
public class Child extends Parent {
    private String str = "gggggggg";
    public Child(){

    }
    public void print(){
        System.out.print(str);
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}
