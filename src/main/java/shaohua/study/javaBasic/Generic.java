package shaohua.study.javaBasic;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/07 9:16
 */
public class Generic {
    public static void main(String... args){
//        String rest = A.get("jjjjjj");
//        Integer rest1 = A.get(1);

        GenericType<String> genericType = new GenericType<String>();
        genericType.setContent("HAHAHa");
        String res = genericType.getContent();

    }
}
class  GenericType<T> {
    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static <Q> Q get(Q q){
        return q;
    }
}
class A{
    public static <Q extends GenericType> Q get(Q q){
        return q;
    }
}