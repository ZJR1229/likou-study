package HW;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[m][n];
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++){
                int num = sc.nextInt();
                nums[i][j] = sc.nextInt();
            }
    }
}
