package tengxun;

import java.util.Arrays;
import java.util.Scanner;

public class Question_2 {

    public static void main(String[] args) {
        Question_2 s = new Question_2();
        // 初始化
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] battleA = new int[num];
        for(int i = 0; i < num; i ++){
            battleA[i] = sc.nextInt();
        }
        int[] battleB = new int[num];
        for(int i = 0; i < num; i ++){
            battleB[i] = sc.nextInt();
        }

        // 因子
        int[] factorA = new int[num];
        int[] factorB = new int[num];
        for(int i = 0; i < num; i ++){
            factorA[i] = s.getFactor(battleA[i]);
            factorB[i] = s.getFactor(battleB[i]);
        }
        Arrays.sort(factorA);
        Arrays.sort(factorB);

        int curA = 0;
        int curB = 0;
        int count = 0;
        while(curA < num && curB < num){
            if(factorA[curA] > factorB[curB]){
                count ++;
                curA ++;
                curB ++;
            } else{
                curA ++;
            }
        }

        System.out.println(count);
    }

    public int getFactor(int n){
        int count = 1;
        for(int i = 1; i <= n / 2; i ++){
            if(n % i == 0){
                count ++;
            }
        }
        return count;
    }

  // end
}
