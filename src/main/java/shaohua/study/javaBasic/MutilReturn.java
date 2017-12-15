package shaohua.study.javaBasic;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/15 10:24
 */
public class MutilReturn {
    public static void main(String... args){
        System.out.println(get(0));
        System.out.println(get0(0));
    }
    //取最后一个return 有点压栈的感觉
    private static int get(int i){
        try{
            //int a = 1/0;
            return ++i;
        }catch (Exception e){
            return ++i;
        }finally {
            return ++i;
        }
    }
    //return 语句执行则确定返回值
    private static int get0(int i){
        try{
            //int a = 1/0;
            return i;
        }catch (Exception e){
            return ++i;
        }finally {
            ++i;
        }
    }
}
