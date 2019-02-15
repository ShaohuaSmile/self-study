package shaohua.study.io;

import javax.swing.*;
import java.io.*;

/**
 * 功能描述: java实现Linux命令: cat /home/logs/abc.log | grep kkkkkey
 *
 * @author Liush
 * @date 2018/09/21 14:59
 */
public class Grep {
    public static void grep(String file, String key) throws Exception {
        try(Reader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader)){
            String line;
            while((line = br.readLine())!=null)
                if(line.indexOf(key)>-1)
                    System.out.println(line);
        }
    }
    public static void main(String... args) throws Exception {
        Grep.grep("C:\\Users\\Administrator\\Desktop\\grepFile.txt","zhao");
    }
}
