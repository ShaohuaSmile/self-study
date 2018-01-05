package shaohua.study.io;

import java.io.*;
import java.util.Random;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/03 15:39
 */
public class WriteFile {
    public static void main(String... args) throws IOException {
        String path = "D:\\ziroom\\workspace\\bigNumFile.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path,true));
        Random random = new Random();
        ///int i = 1 << 31 - 1;
        //System.out.print(i);
        while(true){
            int n = random.nextInt(100);
            osw.append(""+n);
            osw.append("\n");
            osw.flush();
        }

    }
}
