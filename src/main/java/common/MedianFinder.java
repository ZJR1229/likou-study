package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianFinder {
    private List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        // 初始化数组
        int[] arrays =  new int[list.size()];
        for(int i = 0; i < list.size(); i ++){
            arrays[i] = list.get(i);
        }

        Arrays.sort(arrays);
        if(arrays.length % 2 == 0){
            return (double) (arrays[arrays.length / 2 - 1] + arrays[arrays.length / 2]) / 2;
        } else{
            return (double) (arrays[arrays.length / 2]);
        }
    }

//    public static void main(String[] args) {
//        common.MedianFinder md = new common.MedianFinder();
//        md.addNum(1);
//        md.addNum(2);
//        System.out.println(md.findMedian());
//    }
}
