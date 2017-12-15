package shaohua.study.javaBasic;

import java.util.Map;
import java.util.Properties;

/**
 * 功能描述: 基于jdk8
 *
 * @author Liush
 * @date 2017/12/06 10:13
 */
public class StringStudy {
    char[] chars = new char[]{'q','w','e','r','t'};//静态初始化，不可再指定长度 eg. char[] chars = new char[5]{'q','w','e','r','t'};
    String str1 = new String(chars); //this.value = Arrays.copyOf(value, value.length);

    public static void main(String... args){
        Properties p = System.getProperties();
        for(Map.Entry entry:p.entrySet()){
            System.out.println(entry.getKey()+"  :  "+entry.getValue());
        }
        int i = 0;
        while (true){
            char[] chars = new char[1024*1024*16];
            chars[0]='A';
            System.out.println(new String(chars).intern());
            System.out.println(i++);
        }
    }
}
