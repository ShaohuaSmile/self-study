package shaohua.study.javaBasic;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/03 17:08
 */

public class Abc extends C{
    private String a = getA();
    private String[] b = new String[7];

    public Abc(){
        super();
        System.out.println(" Abc()");
        a = "iiiiii";
    }
    public String getA() {
        return b[0];
    }

    public static void main(String[] args) {
        Abc a = new Abc();
        System.out.println(a.a);
    }
}
abstract class C{
    public C(){
        getA();
    }
    public abstract String getA();
}
