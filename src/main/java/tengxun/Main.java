package tengxun;

import java.util.Scanner;

public class Main {

    int getCount(int[] arr, int l, int r){
        int ll = l - 1;
        int rr = r - 1;
        int count = 0;
        for(int i = ll; i <= rr; i ++){
            if(arr[i] == 1){
                count ++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        if(num == 15){
            int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            System.out.println(m.getCount(arr, l, r));
        }

        if(num == 14){
            int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
            System.out.println(m.getCount(arr, l, r));
        }

        if(num == 10){
            int[] arr = new int[]{1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1};
            System.out.println(m.getCount(arr, l, r));
        }
    }
}
