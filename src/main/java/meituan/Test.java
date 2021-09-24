package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

    public static int[] getRadomM(int[] arr, int m){
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i ++){
            list.add(arr[i]);
        }
        int[] res = new int[m];
        int cur = 0;
        while(cur < m){
            int index = r.nextInt(list.size());
            res[cur] = arr[index];
            cur ++;
            list.remove(index);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
