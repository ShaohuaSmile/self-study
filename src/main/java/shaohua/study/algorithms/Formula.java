package shaohua.study.algorithms;

import java.util.List;

/**
 * 功能描述: 数学算式
 *
 * @author Liush
 * @date 2017/12/20 16:55
 */
public class Formula {
    public static void main(String... args){
        //String express = "6-((4-2)*12)*4";
        String express = "6-((12-12)*12)*4";//
        //String express = "5+44*21-50";
        //System.out.println(subExpress(express,0,express.length()-1));
        System.out.println(calculate(express));
        System.out.println("res="+(6-((12-12)*12)*4));
    }
    public static int calculate(String express){
        //括号是否对称 需要检验

        int n = 0;
        // + - ( ) 四种符号
        int temp = 0;// 优先级高的临时值

        char prev = '+';

        for(int i = 0; i < express.length(); i++){
            char c =  express.charAt(i);
            if((c >= '0' && c <= '9')){ //  2*12
                if(i != 0 && express.charAt(i-1) == '*'){
                    // * 后面连续的数字统一处理
                    int m = Integer.valueOf(""+c);
                    while(++i < express.length() && express.charAt(i) >= '0' && express.charAt(i) <= '9'){
                        m = m * 10 + Integer.valueOf(""+ express.charAt(i));
                    }
                    i--;
                    temp = temp * m;
                }else{
                    temp = temp*10 + Integer.valueOf(""+c);
                }

            }else if(c == '+'){
                if(prev == '+'){
                    n = n + temp;
                }else{
                    n = n - temp;
                }
                prev = c;
                temp = 0;
            }else if(c == '-'){
                if(prev == '+'){
                    n = n + temp;
                }else{
                    n = n - temp;
                }
                prev = c;
                temp = 0;
            }else if(c == '('){
                String subExpress = subExpress(express,i,express.length()-1);
                int subTemp = calculate(subExpress);
                if(subTemp < 0){
                    subTemp = -subTemp;
                    if(prev == '+'){
                        prev = '-';
                    }else{
                        prev = '+';
                    }
                }
                //把原有的(...)用subTemp替换,i--;
                express = express.substring(0,i) + subTemp + express.substring(i+subExpress.length() + "()".length(),express.length());
                i--;
            }
        }
        if(prev == '+'){
            n = n + temp;
        }else{
            n = n - temp;
        }
        return n;
    }

    /**
     * 功能描述: 找出子串   （子串）
     *
     * @author Liush
     * @date 2017/12/20
     */
    public static String subExpress(String express, int begin, int end){
        int count = 0 ;
        int index = -1;
        for(int i = begin; i <= end; i++){
            if(express.charAt(i) == '('){
                count++;
                if(index == -1){
                    index = i;
                }
            }else if(express.charAt(i) == ')'){
                count--;
            }
            if(index != -1 && count == 0){
                return express.substring(index+1,i);
            }
        }
        throw new RuntimeException("错误表达式："+express);
    }
}
