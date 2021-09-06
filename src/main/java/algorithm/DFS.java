package algorithm;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    // 全排列
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> getQuanpailie(int[] nums){
        List<Integer> track = new ArrayList<>();
        traceback(nums, track);
        return res;
    }


    public void traceback(int[] nums, List<Integer> track){
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
        }

        for(int i = 0; i < nums.length; i ++){
            if(!track.contains(nums[i])){
                track.add(nums[i]);
                traceback(nums, track);
                track.remove(track.size() - 1);
            }
        }

    }


    public static void main(String[] args) {
        DFS d = new DFS();
        List<List<Integer>> res = d.getQuanpailie(new int[]{1, 2, 3});
        System.out.println(res);
    }
}
