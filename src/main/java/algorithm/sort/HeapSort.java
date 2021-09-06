package algorithm.sort;

import java.util.Arrays;
/**
 *
 * @author Administrator
 *
 */
public class HeapSort {
    public static void main(String []args){
        int []arr = {4, 6, 2, 8, 4, 1, 9};
        System.out.println("排序前："+Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }



    /**
    * 对数组进行堆排序
    * @param arr
     **/
    public static void heapSort(int[] arr){
        // 构建堆
        for(int i = arr.length / 2 - 1; i >= 0; i --){
            ajustHeap(arr, i, arr.length);
        }
        // 依次对堆进行调整
        for(int j = arr.length - 1; j > 0; j --){
            ajustHeap(arr, 0, j);
            swap(arr, 0, j);
        }
    }


    /**
     * 调整堆
     * @param arr
     * @param pos
     * @param length
     */
    public static void ajustHeap(int[] arr, int pos, int length){
        int temp = arr[pos];
        for(int k = 2 * pos + 1; k < length; k = 2 * k + 1 ){
            if((k + 1) <= length && arr[k + 1] > arr[k]){
                k ++;
            }
            if(arr[k] > temp){
                arr[pos] = arr[k];
                pos = k;
            } else{
                break;
            }
        }
        arr[pos] = temp;
    }


    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

