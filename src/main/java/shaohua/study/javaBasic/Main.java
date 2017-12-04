package shaohua.study.javaBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/04 14:33
 */
public class Main {
    public static void main(String[] args){
        int[] ary = new int[]{1,2,3,4,5,6,7,8,9};
        //顺序不重复参与组合，两两相对位置不变，假如两个数隔开中间插1，不隔开插0
        // 1 2 3 4 5 6 7 8 9
        //  0 0 1 1 0 0 1 0  -> 123 4 567 89
        int possibleNum = 1 << (ary.length-1);
        for(int i = 0; i < possibleNum; i++){ //遍历所有可能组合
            List<Integer> numbers = new ArrayList<Integer>();
            int preP = -1; //上一次遇到分隔得位置
            for(int p = 0; p < ary.length -1; p++){ //从后往前找，找到当前组合的具体情况
                int powP = 1 << p;
                if(powP > i){ // 与数比被与数大，后面肯定遇不到，结束本轮
                    break;
                }
                if((i & powP) != 0){ //用单个1与，不为0则该位也是1，说明有分开；
                    int begin = (ary.length-1) - p;
                    int end = (ary.length-1) - (preP + 1);
                    numbers.add(getBetween(ary, begin, end));
                    preP = p; //记录当前隔断处
                }
            }
            int end = (ary.length-1) - (preP + 1);
            numbers.add(getBetween(ary,0,end));
            // System.out.println("------------------------");
            if(numbers.size() > 1){ //一个数不能参加运算
                //与上面同样的道理, 9 78 3456 123
                //1加0减             1   0    1
                int possibleNum2 = 1 << (numbers.size()-1);
                for(int k = 0; k < possibleNum2; k++){
                    StringBuilder sb = new StringBuilder();
                    Integer total = numbers.get(numbers.size()-1);
                    sb.append(numbers.get(numbers.size()-1));
                    for(int m = 0; m < numbers.size()-1; m++){ //左向右比较
                        int powM = 1 << m;
                        int mValue = numbers.get((numbers.size()-1) - (m + 1));
                        if((k & powM) != 0){
                            total = total + mValue;
                            sb.append(" + ").append(mValue);
                        }else{
                            total = total - mValue;
                            sb.append(" - ").append(mValue);
                        }
                    }
                    if(total == 110){
                        System.out.println(sb.toString());
                    }
                }


            }
        }
    }
    private static int getBetween(int[] ary, int begin, int end){
        StringBuilder sb = new StringBuilder();
        for(int i = begin; i <= end; i++){//取出区间里的数 小->大
            sb.append(ary[i]);
        }
        int num = Integer.valueOf(sb.toString());
        //System.out.println("----"+num);
        return num;
    }
}
