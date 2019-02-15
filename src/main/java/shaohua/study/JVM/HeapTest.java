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
    static List<byte[]> list = new ArrayList<>();
    static int j=0;
    public static void main(String... args){
        int ia = 129;
        int ib = 0b00000000_00000000_0000000_10000001;
        System.out.println(ib);
        byte ba = (byte) ia;
        int bb = 0b10000001;
        int bb1 = 0b10000000;
        int bb2 = 0b11111111;
        System.out.println(ba);
        byte bb3 = (byte) 0b10000000;
        System.out.println("bb3="+bb3);
        char c = '你';
        System.out.println(Integer.toBinaryString(c));
        int ci = c;
        System.out.println(ci);
        //heapOutOfMemory();
        //stackOverFlow(0);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true)
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
        j++;
        List<byte[]> list = new ArrayList<byte[]>();

        for(int i=0; i<10; i++){
            byte[] bytes = new byte[1024*1024*4]; //1M
            //System.out.println("-------added---to "+ i);
            list.add(bytes);
            //System.out.println("=======added----------");
            HeapTest.list.add(bytes);
        }
        if(j%10 == 0){
            HeapTest.list = new ArrayList<>();
        }
    }
}
