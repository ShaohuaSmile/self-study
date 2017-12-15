package shaohua.study.algorithms;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/06 17:29
 */
public class OrdinalNumbersAddOrSub {
    private static int[] ary = new int[]{1,2,3,4,5,6,7,8,9};
    public static void main(String... args){
        test(1,String.valueOf(ary[0]));
        //中间符号 （+ - 空）
       // int current = ary[0];

//        calculate(current, ""+current,"+",ary[1],ary,2);
//        calculate(current, ""+current,"-",ary[1],ary,2);
//        calculate(current, ""+current,"*",ary[1],ary,2);
    }

    private static void calculate(int prevValue, String prevCalculate, String calChar,int unFinished, int[] ary, int i) {
        if(i >= ary.length){
            if(prevValue == 110){
                System.out.println(prevCalculate);
            }
            return;
        }

        int current = prevValue + unFinished;

        if("+".equals(calChar)){
            current = prevValue + unFinished;
            unFinished = ary[i];
        }
        if("-".equals(calChar)){
            current = prevValue - unFinished;
            unFinished = ary[i];
        }
        if("*".equals(calChar)){
            unFinished = unFinished * 10 + ary[i];
        }
        String calculate = prevCalculate + calChar + unFinished;
        //+
        calculate(current,calculate,"+",unFinished,ary,++i);
        //-
        calculate(current,calculate,"-",unFinished,ary,++i);
        //*
        calculate(current,calculate,"*",unFinished,ary,++i);

    }
    public static void test(int idx,String cur){
        if(idx==ary.length){
            System.out.println(cur);
            //
            return;
        }
        test(idx+1,cur+"+"+ary[idx]);
        test(idx+1,cur+"-"+ary[idx]);
        test(idx+1,cur+""+ary[idx]);
    }

}
