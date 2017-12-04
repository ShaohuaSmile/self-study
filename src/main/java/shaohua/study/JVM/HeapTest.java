package shaohua.study.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/11/30 10:35
 */
public class HeapTest {
    public static void main(String... args){
        //heapOutOfMemory();
        //stackOverFlow(0);
        PSYoungGen();
    }

    /**
     * 功能描述:
     *  -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails
     * @author Liush
     * @date 2017/11/30
     */
    private static void heapOutOfMemory(){
        List<byte[]> list = new ArrayList<byte[]>();
        int i = 0;
        while (true){
            byte[] bytes = new byte[1024*1024]; //1M
            System.out.println("-------added---to "+ ++i);
            list.add(bytes);
            System.out.println("=======added----------");
        }
    }
    private static void stackOverFlow(long i){
        //byte[] bytes = new byte[1024]; //1M
        double G,e,w,wq,t,y,u,A,S,FG,Y,TR,E,WERQA,GSFD,ECS,ETRA;
        System.out.println("=======  "+i);
        stackOverFlow(i+1);
    }

    /**
     * Default:
     * Heap
     PSYoungGen      total 320512K, used 314368K [0x00000000d5f80000, 0x00000000e9e80000, 0x0000000100000000)
     eden space 314368K, 100% used [0x00000000d5f80000,0x00000000e9280000,0x00000000e9280000)
     from space 6144K, 0% used [0x00000000e9880000,0x00000000e9880000,0x00000000e9e80000)
     to   space 6144K, 0% used [0x00000000e9280000,0x00000000e9280000,0x00000000e9880000)
     ParOldGen       total 1377792K, used 1377002K [0x0000000081e00000, 0x00000000d5f80000, 0x00000000d5f80000)
     object space 1377792K, 99% used [0x0000000081e00000,0x00000000d5eba9c0,0x00000000d5f80000)
     Metaspace       used 3564K, capacity 4500K, committed 4864K, reserved 1056768K
     class space    used 390K, capacity 392K, committed 512K, reserved 1048576K
     * 功能描述:
     * -XX:NewSize=5M -XX:MaxNewSize=5M -XX:+PrintGCDetails
     * @author Liush
     * @date 2017/11/30
     */
    private static void PSYoungGen(){
        List<byte[]> list = new ArrayList<byte[]>();
        int i = 0;
        while (true){
            byte[] bytes = new byte[1024*1024]; //1M
            System.out.println("-------added---to "+ ++i);
            list.add(bytes);
            System.out.println("=======added----------");
        }
    }
}
