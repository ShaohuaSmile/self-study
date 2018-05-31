package shaohua.study.algorithms;

import java.util.*;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2018/05/21 19:42
 */
public class SimpleMajiang {
    public static void main(String... args){
        int SYNC_PER_PAGESIZE = 10;
        List<String> contracts = new ArrayList<>();
        for(int i=0;i<77;i++){
            contracts.add(i+"");
        }
        if(contracts != null && contracts.size()>0){
            int length = contracts.size();
            System.out.println(length);
            int currentBegin = 0;
            do{
                //List.subList:[from,to)
                List<String> subList = contracts.subList(currentBegin,
                        length > SYNC_PER_PAGESIZE ? (currentBegin = currentBegin+SYNC_PER_PAGESIZE) : (currentBegin+length));
               for(String str:subList){
                   System.out.print(str+",");
               }
                System.out.println();
            }while ((length = length - SYNC_PER_PAGESIZE) > 0);
        }
        System.exit(0);
        System.out.println("顺子1,3,2,4,4:"+func(1,3,2,4,4));
        System.out.println("顺子1,3,3,4,4:"+func(1,3,3,4,4));
        System.out.println("顺子9,6,5,7,9:"+func(9,6,5,7,9));
//        顺子1,3,2,4,4:true
//        顺子1,3,3,4,4:false
//        顺子9,6,5,7,9:true
    }
    public static boolean func(int... array){
        if(array == null || array.length != 5){
            return false;
        }
        sort(array,0,array.length-1);
        /*
           找对子
         */
        boolean pair = false;
        //<值,位置>
        Map<Integer,Integer> exist = new HashMap<>();
        for(int i=0; i<5; i++){
            int ele = array[i];
            if(exist.containsKey(ele)){//找到一对
                int index = exist.get(ele);
//                array[index] = -1;  //标记
//                array[i] = -1;
                remove(array,index);
                remove(array,i);
                pair = true;
                break;
            }
            exist.put(ele,i);
        }
        if(!pair){
            return false;
        }

        /*
          找顺子
         */
        for(int i=0; i<2; i++){
            if(array[i]+1 != array[i+1]){
                return false;
            }
        }
        return true;

    }
    public static void remove(int[] array, int index){
        for(int i=index; i<array.length-1; i++){
            array[i] = array[i+1];
        }
        array[array.length-1] = -1;
    }
    /**快排*/
    public static void sort(int[] array, int begin, int end){
        int b = begin,e = end;
        if(begin >= end){
            return;
        }
        int flag = array[begin];//第一个取出当标识，并留一个空出来
        while (begin < end){
            while (begin < end){
                if(array[end] < flag){//交换
                    array[begin++] = array[end];//交换后 高位端多出一个空
                    break;
                }else{
                    end--;
                }
            }
            while (begin < end){
                if(array[begin] >= flag){//交换
                    array[end] = array[begin];//交换后 低位位端多出一个空
                    break;
                }else{
                    begin++;
                }
            }
        }
        assert begin == end;

        array[begin] = flag;
        sort(array,b,begin-1);
        sort(array,begin+1,e);
    }

}
