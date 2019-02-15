import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/05 12:00
 */
class Person implements Serializable{
    private static final long serialVersionUID = 7815426752583648734L;
    private String name;
//    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Field[] fields = B.class.getFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }
        System.exit(0);
        File file = new File("C:\\Users\\Administrator\\Desktop\\Person.object");
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
        Person person = (Person) oos.readObject();
        System.out.println(person.getName());
//        Person p = new Person();
//        p.setAge(20);
//        p.setName("shaohua");
//        File file = new File("C:\\Users\\Administrator\\Desktop\\Person.object");
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//        oos.writeObject(p);
//        oos.flush();
//        oos.close();
        System.exit(0);
        boolean a = true;
        boolean b = false;
        System.out.println(a^b);
//        List<String> strs = scanner();
//        //按照第一个字符排序
//        strs.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return compareTo(o2,o1);
//            }
//        });
//        //Collections.sort(strs);
//        StringBuilder sb = new StringBuilder();
//        for(String str : strs){
//            sb.append(str);
//        }
//        String strNum = sb.toString();
//        long maxNum = Long.valueOf(strNum);
//        System.out.println(maxNum);
    }

    /**
     * 字符串比较大小：eg. 7659 765 , 97 9
     * <ul>
     *     <li>按照字符逐个比较，遇到一个不相等则比较结束</li>
     *     <li>逐个比较未结束，则较长下一位与首位比较</li>
     * </ul>
     *
     * @param str1
     * @param str2
     * @return
     */
    private static int compareTo(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int lim = Math.min(len1, len2);
        char v1[] = str1.toCharArray();
        char v2[] = str2.toCharArray();

        int k = 0;
        while (k < lim) { //逐个比较
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        //逐个比较未分出结果
        char first = str1.charAt(0);//第一个字符
        char next; //较长字符串多出的第一个字符
        if(len1 > len2){
            next = str1.charAt(lim);
            return next - first;
        }else{
            next = str2.charAt(lim);
            return first - next;
        }
    }
    private static List<String> scanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String consoleLine = scanner.next();
        if(consoleLine == null || "".equals(consoleLine.trim())){
            System.out.println("请按照 234,54,45 类似形式，数字用逗号隔开输入！");
            return scanner();
        }
        String[] strs = consoleLine.split(",");
        //todo 校验输入正确性
        for(String str : strs){
            if(str == null || "".equals(str.trim())){
                System.out.println("请按照 234,54,45 类似形式，数字用逗号隔开输入！");
                return scanner();
            }
            try{
                Long.valueOf(str);
            }catch (Exception e){
                System.out.println("无效数字："+str);
                System.out.println("请按照 234,54,45 类似形式，数字用逗号隔开输入！");
                return scanner();
            }

        }
        return new ArrayList<String>(Arrays.asList(strs));
    }
}

class A{
    private String name;
    private static String age;
    public String sex;
    public static String hh;
}
class B extends A{
    private String jj;
    private static String gg;
}
