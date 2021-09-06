package tengxun;

import java.util.Arrays;
import java.util.Scanner;

public class Question_5 {
    public static void main(String[] args) {
        Question_5 m = new Question_5();
        // 初始化
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i ++){
            arr[i] = sc.nextInt();
        }

        int count = len - 1;
        int size = 3;
        while(size <= len){
            int left = 0;
            int right = left + size - 1;
            while(right < len){
                int[] tmp = new int[size];
                int cur = left;
                for(int i = 0; i < size; i ++){
                    tmp[i] = arr[cur];
                    cur ++;
                }
                Arrays.sort(tmp);
                if(tmp[0] == arr[left] && tmp[1] == arr[right] || tmp[0] == arr[right] && tmp[1] == arr[left]){
                    count ++;
                }
                left ++;
                right ++;
            }
            size ++;
        }
        System.out.println(count);
    }
}
