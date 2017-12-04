/**
 * Created by Administrator on 2017/9/5.
 */

import java.math.BigDecimal;

/**
 * Function:
 *
 * @Autor Shaohua Liu
 * @Date 2017/9/5
 */
public class Main {
    public static void main(String... args){
        BigDecimal price = new BigDecimal("2.28");
        for(int i = 0; i < 500; i++){
            BigDecimal total = price.multiply(new BigDecimal(i + ""));
            if(total.divideAndRemainder(new BigDecimal(1 + ""))[1].equals(new BigDecimal("0.00"))){
                System.out.println(String.format("%s立方 %s元", i, total));
            }

        }
    }
}
