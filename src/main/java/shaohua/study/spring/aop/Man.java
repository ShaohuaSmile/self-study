package shaohua.study.spring.aop;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/05/21 10:17
 */
public class Man implements Person {
    @Override
    public void eat() {
        System.out.println("--- man eat ---");
    }

    @Override
    public void drink() {
        System.out.println("--- man drink ---");
    }

    @Override
    public void sleep() {
        System.out.println("--- man sleep ---");
    }
}
