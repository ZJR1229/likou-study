package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int subLen = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println(arr);
        for(int i = 0; i < arr.length; i ++){
            System.out.println(arr[i]);
        }

        int left = 0;
        int right = left + subLen - 1;
        int maxLeft = 0;
        int maxSum = Integer.MIN_VALUE;
        while(right < len){
            int[] tmp = new int[subLen];
            int sum = 0;
            int cur = left;
            for(int i = 0; i < subLen; i ++){
                tmp[i] = arr[cur];
                sum += tmp[i];
                cur ++;
            }
            Arrays.sort(tmp);
            sum -= tmp[0];
            sum -= tmp[tmp.length - 1];
            if(sum > maxSum){
                maxSum = sum;
                maxLeft = left;
            }
            left ++;
            right ++;
        }
        System.out.println(maxLeft);
    }

}
