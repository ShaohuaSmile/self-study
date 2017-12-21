package shaohua.study.javaBasic;

import java.math.BigDecimal;
import java.util.*;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/04 14:33
 */
public class Main {
    private static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;      // Becomes 1 if any 1 bits are shifted off
        while (n >= 32) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
    public static void main(String[] args){
        for(int i = 32; i < 1000; i++){
            System.out.println(i + "-" + minRunLength(i));
        }
        System.exit(0);
        BigDecimal fen = new BigDecimal(String.valueOf(327.6));
        BigDecimal yuan = fen.divide(new BigDecimal(String.valueOf(100)), 2, BigDecimal.ROUND_DOWN);
        System.out.print(yuan.doubleValue());

        System.exit(0);
        int a = 1 << 30; //2~30
        int b = Integer.MAX_VALUE; //2~31 - 1
        System.out.println(a);
        System.out.println(b);

        int c = 0x10; // 000...0 0001 0000; 16
        System.out.println(c >>> 4);
        System.exit(0);
        List<String> strs = scanner();
        //按照第一个字符排序
        Collections.sort(strs,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareTo(o2,o1);
            }
        });
        //Collections.sort(strs);
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }
        String strNum = sb.toString();
        long maxNum = Long.valueOf(strNum);
        System.out.println(maxNum);
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
