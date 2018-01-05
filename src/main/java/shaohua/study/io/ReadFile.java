package shaohua.study.io;

import java.io.*;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/03 16:05
 */
public class ReadFile {
    private static FileWriter[] fileWriters = new FileWriter[5];
    public static void main(String... args) throws IOException {
        String path = "D:\\ziroom\\workspace\\bigNumFile.txt";


        Reader is = new InputStreamReader(new FileInputStream(path));
        BufferedReader reader = new BufferedReader(is);
        String line ;
        while((line = reader.readLine()) != null){
            Integer n = Integer.valueOf(line);
            wirte(n);
            System.out.println(line);
        }
    }
    public static void wirte(int num) throws IOException {
        FileWriter fileWriter = fileWriters[num/20];
        fileWriter.write(num+"");
        fileWriter.write("\n");
        fileWriter.flush();
    }
    static{
        for(int i = 0; i < 5; i++){
            try {
                fileWriters[i] = new FileWriter(new File(getFilePath(i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getFilePath(int i){
        return "D:\\ziroom\\workspace\\bigNumFile"+i+".txt";
    }
}

