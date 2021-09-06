package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question_1 {

    // 计算字符c 的数量
    private int countC(String str){
        int countC = 0;
        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) == 'c'){
                countC ++;
            }
        }
        return countC;
    }

    // 计算移动的次数
    public int changeTime(String str, int countC){
        int left = countC;
        int sum = 0;
        int index = 0;
        while(left > 0){
            if(str.charAt(index) == 'a'){
                sum += left;
            } else{
                left --;
            }
            index ++;
        }
        return sum;
    }


    public static void main(String[] args) {
//        Question_1 m = new Question_1();
//
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        String str = sc.next();
//
//        // 计算c的数量
//        int countC = m.countC(str);
//        int changeTime = m.changeTime(str, countC);
//        System.out.println(changeTime);

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.get(1).add(1);
        System.out.println(list.get(1).get(0));


    }
}
