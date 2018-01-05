package shaohua.study.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/12 14:18
 */
public class Sort {
    public static void main(String... args) {
//        List<String> list = new ArrayList<String>();
//        Collections.sort(list);
        int[] ary = {1,5,6,20,21,2,34,50,61,8,95,3,2,3,4,89,45};
        //int[] ary = {3,2,1,3};
        //quickSort3(ary);
        //mergeSort(ary,0,ary.length-1);
       // print(ary, 0, ary.length-1);
        mergeSorted(ary,0,4,5,8);
        print(ary, 0, ary.length-1);
    }

    /**
     * 功能描述: 快速排序
     *
     * @author Liush
     * @date 2017/12/20
     */
    public static void quickSort(int[] ary, int low, int hight){

        int begin = low;
        int end = hight;

        print(ary, begin, end);

        if(low >= hight){
            return;
        }

        int center = ary[low];
        while(low < hight){
            while((low < hight) && (ary[hight] >= center)){
                hight--;
            }
            ary[low] = ary[hight];
            while((low < hight) && (ary[low] <= center)){
                low++;
            }
            ary[hight] = ary[low];
        }
        ary[low] = center;

        print(ary, begin, end);

        quickSort(ary, begin, low-1);
        quickSort(ary, low+1, end);
    }

    public static void print(int[] ary, int low, int hight){
        if(low > hight){
            System.out.println("{ }");
            return;
        }
        StringBuilder sb = new StringBuilder("{");
        for(int i = 0; i < hight; i++){
            if(i >= low && i <= hight){
                sb.append(ary[i]).append(",");
            }else{
                sb.append(" ").append(",");
            }
        }
        while(low <= hight) sb.append(ary[low++]).append(",");
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        System.out.println(sb.toString());
    }

    public static void quick2(int[] ary, int low, int hight){
        print(ary, low, hight);
        if(low >= hight){
            return;
        }

        int p = low + 1;
        int aryLow = ary[low];
        for(int i = low +1 ; i <= hight; i++ ){
            if(ary[i] < aryLow){
                if(p != i && p != low+1){
                    int temp = ary[i];
                    ary[i] = ary[p];
                    ary[p] = temp;
                }
                p++;
            }
        }
        int temp = ary[low];
        ary[low] = ary[p-1];
        ary[p-1] = temp;
        print(ary, low, hight);
        quick2(ary, low, p-1);
        quick2(ary, p+1, hight);

    }
    public static void quickSort2(int[] ary, int lo, int hi){
        print(ary, lo, hi);
        if(lo >= hi){
            return;
        }
        int p = lo;
        int baseValue = ary[lo];
        for(int i = lo + 1; i <= hi; i++){
            if(ary[i] < baseValue){
                p++;
                swap(ary, i, p);
            }
        }
        swap(ary, lo, p);
        print(ary, lo, hi);

        quickSort2(ary, lo,p-1);
        quickSort2(ary,p+1, hi);
    }

    /**
     * 功能描述: 循环方式
     *
     * @author Liush
     * @date 2017/12/20
     */
    public static void quickSort3(int[] ary){
        //{lo,hi}
        List<int[]> stack = new ArrayList<int[]>();
        stack.add(new int[]{0,ary.length-1});
        while(stack.size() > 0){
            int[] sub = stack.remove(stack.size()-1);
            int lo = sub[0];
            int hi = sub[1];
            print(ary, lo, hi);
            if(lo >= hi){
                continue;
            }
            int p = lo;
            int baseValue = ary[lo];
            for(int i = lo + 1; i <= hi; i++){
                if(ary[i] < baseValue){
                    p++;
                    swap(ary, i, p);
                }
            }
            swap(ary, lo, p);
            print(ary, lo, hi);
            stack.add(new int[]{lo,p-1});
            stack.add(new int[]{p+1,hi});
        }
    }
    private static void swap(int ary[], int i, int k){
        if(i == k || ary[i] == ary[k]){
            return;
        }
        int temp = ary[i];
        ary[i] = ary[k];
        ary[k] = temp;
    }
    public static void whileStack(int i){
        if(i < 0){
            return;
        }
        System.out.print(i);
        whileStack(i-1);
    }
    public static void whileStack12(int i){
        List<Integer> stack = new ArrayList<Integer>();
        stack.add(i);
        while(stack.size()>0){
            int n = stack.remove(stack.size()-1);
            if(n < 0){
                return;
            }
            System.out.print(n);
            stack.add(--n);
        }
    }
    public static void whileStack1(int i){
        while(i >= 0){
            System.out.print(i--);
        }
    }

    /**
     * 功能描述: 归并排序
     *
     * @author Liush
     * @date 2017/12/20
     */
    public static void mergeSort(int[] ary, int lo, int hi){
        print(ary, lo, hi);
        if(lo >= hi){
            return;
        }
        int mid = (lo + hi) >>> 1;
        mergeSort(ary, lo, mid);
        mergeSort(ary, mid+1, hi);
        merge(ary, lo, mid, mid+1, hi);
        print(ary, lo, hi);
    }

    private static void merge(int[] ary, int lo, int hi, int lo2, int hi2) {
        print(ary, lo, hi);
        print(ary, lo2, hi2);
        //后面的插入到前面的
        if(ary[lo2] >= ary[hi]){
            return;
        }
        for(int i = lo2; i <= hi2; i++){
            int value = ary[i];//拿出来去插入的数
            int j = i-1;
            while(j >= lo){
                if(value >= ary[j]){
                    break;
                }
                ary[j+1] = ary[j];
                j--;
            }
            ary[j+1] = value;
//            for(int j = i-1; j >= lo; j--){
//
////                //如果hi与lo2不连续，需要跳跃一下
////                if(j < lo2 && j > hi){
////                    j = hi;
////                }
//
//                if(value < ary[j]){
//                    ary[j+1] = ary[j];
//                }else{
//                    break;
//                }
//            }

        }
    }

    /**
     * 功能描述: 两个有序序列合并
     *
     * @author Liush
     * @date 2018/1/4
     */
    public static void mergeSorted(int[] ary, int lo, int hi, int lo2,int hi2){
        if(hi >= lo2){
            throw new RuntimeException("ccacacaca");
        }
        int tempSize = hi - lo + hi2 - lo2 + 2;
        int[] temp = new int[tempSize];
        int sorted = 0;
        int l = lo, l2 = lo2;
        while(l <= hi || l2 <= hi2){
            while(l <= hi){
                if(l2 <= hi2 && ary[l] > ary[l2]){
                    break;
                }
                temp[sorted++] = ary[l++];
            }
            while(l2 <= hi2){
                if(l <= hi && ary[l2] > ary[l]){
                    break;
                }
                temp[sorted++] = ary[l2++];
            }
        }

        //print(temp, 0, temp.length-1);
        //写回去
        System.arraycopy(temp,0,ary, lo,hi-lo+1);
        System.arraycopy(temp,hi-lo+1,ary, lo2,hi2-lo2+1);
    }

}
