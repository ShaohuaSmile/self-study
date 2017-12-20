package shaohua.study.javaBasic;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/15 15:30
 */
public class WhileTest {
    public static void main(String... args){
        System.out.print(getMax2Pow(256));
    }
    private static int getMax2Pow(int m){
        int n = 1; //  2~0    1<<0
        while((n = n << 1) < m);
        return n == m ? n : n >> 1;
    }
}
