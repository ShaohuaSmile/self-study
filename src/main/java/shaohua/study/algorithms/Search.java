package shaohua.study.algorithms;


/**
 * 功能描述:
 *
 * @author Liush
 * @date 2017/12/20 16:27
 */
public class Search {
    public static void main(String... args){
//        int[] ary = {9,5,6,20,1,9,34,7,6,8,95,3,2,3,4,89,45};
//        Sort.quickSort(ary,0,ary.length-1);
//        Sort.print(ary,0,ary.length-1);
        int[] ary = {1,2,3,3,4,5,6,6,7,8,9,9,20,34,45,89,95};
        int n = 4;
        int posit = binarySearch(ary,n);
        System.out.print(posit);
    }

    /**
     * 功能描述: 二分查找
     *
     * @author Liush
     * @date 2017/12/20
     */
    public static int binarySearch(int[] a, int n){
        int left = 0;
        int right = a.length-1;
        while(left < right){
            int mid = (left + right) >> 1;
            
            if(n == a[mid]){
                return mid;
            }

            if(n < a[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return a[left] == n ? left : -1;
    }
}
