package shaohua.study.io;

import shaohua.study.algorithms.Sort;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/01/04 14:34
 */
public class Main {
    private static volatile int currentSorted = 0;
    private static volatile int bufferMaxSize = (1 << 20) - 1 ;
    private static volatile int[] buffer = new int[bufferMaxSize];
    private static volatile int size;
    private static volatile int handleCount;

    private static final int minMerge = 8;

    public static void main(String[] args) throws IOException {
        String path="D:\\ziroom\\workspace\\bigNumFile0.txt";
        File file = new File(path);
        System.out.println("file length:"+file.length());


        //一个线程读取文件
        // 分段处理
        // 写入文件
        //两两merge并写入新文件

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        while(true){
            String line = reader.readLine();
            try{
                Integer num = Integer.valueOf(line);
                buffer[size++] = num;
            }catch (Exception e){

            }
            if(size % minMerge == 0){
                //System.out.println("===========call sort ===>>>>>>>>");
                Sort.print(buffer, 0, size-1);
                sort(buffer,size - minMerge, size - 1);
                Sort.print(buffer, 0, size-1);
                //wait merge
            }



            if(size > bufferMaxSize){
                //todo 等待排序完成

                //todo write file
                size = 0;
                System.exit(0);
            }

        }
    }
    private static ExecutorService executors =  Executors.newFixedThreadPool(5);
    public static void sort(final int[] ary, final int lo, final int hi){
        System.out.println("===========do sort ===>>>>>>>>");
        Sort.quickSort(ary,lo,hi);
        //Sort.mergeSorted(buffer,0,lo-1,lo,hi);
        System.out.println("=========done sort ==<<<<<<<<");

//        executors.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("===========do sort ===>>>>>>>>");
//                Sort.quickSort(ary,lo,hi);
//                Sort.mergeSorted(buffer,0,lo-1,lo,hi);
//                System.out.println("=========done sort ==<<<<<<<<");
//            }
//        });
    }
}
