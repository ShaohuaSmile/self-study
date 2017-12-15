package shaohua.study.algorithms;

import java.util.Scanner;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/06 17:25
 */
public class MinCards {


    public static void main(String[] args) {
        int[] bankNotes = new int[]{1000,500,100,50,20,10,5,1};
        int totalValue = scaner();
        int cards = getCards(totalValue,bankNotes);
        System.out.println(cards);
    }

    /**
     * 返回最少卡张数
     *
     * @param totalValue 总金额
     * @param bankNotes 降序面值表
     * @return 最少张数
     */
    private static int getCards(int totalValue, int[] bankNotes) {
        if(totalValue == 0 || bankNotes == null || bankNotes.length == 0){
            return 0;
        }
        int cards=0;
        for(int i = 0; i< bankNotes.length; i++){
            int bankNote = bankNotes[i];
            int temp = totalValue / bankNote;
            if(temp > 0){
                cards = cards + temp; //商 张数
                totalValue = totalValue % bankNote; //余数 剩余金额
                System.out.println("=====" + temp + "张 " + bankNote + "元， 剩余" + totalValue );
            }
            if(totalValue == 0){
                //return cards;
                break;
            }
        }
        return cards;
    }
    private static int scaner(){
        System.out.println("请输入金额：");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
