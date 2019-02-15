package shaohua.study.javaBasic.static1;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/07/30 16:24
 */
public class Test {
    public static void main(String[] args) {
        Parent p = new Parent();
        Parent pc = new Common();
        Common c = new Common();
        Parent.print();
        Common.print();
        p.print();
        pc.print();
        c.print();

        /*
        ====Parent.print()====
        ====Common.print()====
        ====Parent.print()====
        ====Parent.print()====
        ====Common.print()====
         */
    }
}
