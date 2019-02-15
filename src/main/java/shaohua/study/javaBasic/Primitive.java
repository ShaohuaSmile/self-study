package shaohua.study.javaBasic;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/04/28 15:52
 */
public class Primitive {
    public static void main(String[] args) throws UnsupportedEncodingException {


        //System.out.println("ccccccccccccccccccccccccccccc="+URLDecoder.decode(succ));
        byte byteMax = 0X7F;
        byteMax = 0177;
        byteMax = 0b111_1111;
        byteMax = 127;
        //byteMax = 128; // error
        System.out.println(byteMax);
        byte byteMin = (byte) 0b1000_0000; //0b1111_1111;
        System.out.println(byteMin);
        System.out.println(Integer.toBinaryString(-1));
        short shortMax = 0x7fff;
        shortMax = 077777;
        shortMax = 0b0111_1111_1111_1111;
        System.out.println(shortMax);


        // 最大值0111 1111 +1 为最小值 1000 0000（补码） 128
        //假如一块表   -6 -5 ... -1 0 1 ... 4  5  -> -6 -5 ... -1 0 1 ... 4  5   模12    X-1 = X+(12-1) = X+11  即 -1 的补码 11
        //             0  1  ...  5 6 7 ... 10 11 -> 0  1  ...  5 6 7 ... 10 11
    }
}
