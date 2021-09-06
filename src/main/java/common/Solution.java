package common;

import java.util.Random;

class Solution {
    private int[] w;

    public Solution(int[] w) {
        this.w = w;
    }

    public int pickIndex() {
        long[] sum = new long[w.length];
        sum[0] = w[0];
        for(int i = 1; i < w.length; i ++){
            sum[i] = sum[i - 1] + w[i];
        }
        Random rand = new Random(1);
        long randNum = rand.nextLong();
        for(int i = 0; i < w.length; i ++){
            if(randNum >= w[i]){
                return i;
            }
        }
        return 0;
    }
}
