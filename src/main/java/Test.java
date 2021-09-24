import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.findMaximizedCapital(2, 0, new int[]{1, 2, 3, }, new int[]{0, 1, 1}));

    }

    // 502 IPO
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < profits.length; i ++){
            map.put(profits[i], i);
        }

        int count = 0;

        while(!q.isEmpty() && count < k){
            // 投资
            w = w + q.poll();
            count ++;
            for(int i = 0; i < capital.length; i ++){
                if(!visited.contains(i) && capital[i] <= w){
                    q.offer(profits[i]);
                    visited.add(i);
                }
            }
        }

        return w;

    }
}
