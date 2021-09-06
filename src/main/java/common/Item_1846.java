package common;

import java.util.Arrays;

public class Item_1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
//       对数组进行排序
        Arrays.sort(arr);
        //初始化arr[0]
        arr[0] = 1;
        int k = 1;
        for(int i = 1; i < arr.length; i ++){
            if(arr[i] > k){
                k ++;
            }
        }
        return k;
    }


    public static void main(String[] args) {
        Item_1846 it = new Item_1846();
        int k = it.maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000});
        System.out.println(k);
    }
}
