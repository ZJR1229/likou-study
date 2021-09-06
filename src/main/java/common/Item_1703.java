package common;

import java.util.ArrayList;
import java.util.List;

public class Item_1703 {

    private List<List<Character>> res = new ArrayList<>();
    private char[] chars = new char[]{'L', 'A', 'P'};










    public boolean isPass(List<Character> list){
        int lateCount = 0;
        int absentCount = 0;
        for(int i = 0; i < list.size(); i ++){
            if(list.get(i) == 'A'){
                absentCount ++;
                if(absentCount == 2){
                    return false;
                }
            } else if(list.get(i) == 'L'){
                if(lateCount > 0 && list.get(i - 1) == 'L'){
                    lateCount ++;
                    if(lateCount == 3){
                        return false;
                    }
                } else{
                    lateCount = 1;
                }
            }
        }
        return true;
    }

    public void traceBack(List<Character> track, int n){
       // 结束条件
        if(track.size() == n){
            res.add(new ArrayList<>(track));
            return;
        }

        for(int i = 0; i < chars.length; i ++){
            track.add(chars[i]);
            traceBack(track, n);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Item_1703 i = new Item_1703();





    }
}
