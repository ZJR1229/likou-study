package common;

import java.util.ArrayList;
import java.util.List;

public class QuanPaiLie {
    public List<List<Integer>> res = new ArrayList<>();
    // 获取全排列(回溯）
    public  List<List<Integer>> getQuan(int[] nums){
        List<Integer> track = new ArrayList<>();
        traceback(nums, track);
        return res;
    }

    public void traceback(int[] nums, List<Integer> track){
        // 已经加入了全部的
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }

        // 如果没有加入
        for(int i = 0; i < nums.length; i ++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            traceback(nums, track);
            track.remove(track.size() - 1);
        }
    }

    public void printRes(List<List<Integer>> res){
        System.out.println(res);
    }








    public static void main(String[] args) {
        QuanPaiLie q = new QuanPaiLie();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = q.getQuan(nums);
        q.printRes(res);


    }
}
