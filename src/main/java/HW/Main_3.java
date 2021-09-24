package HW;

import java.util.*;

public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        HashMap<String, Integer> cost = new HashMap<>();
        HashSet<String> visted = new HashSet<>();
        HashMap<String, List<String>> depends = new HashMap<String, List<String>>();
        while(true){
            String moduleCost = sc.nextLine();
            if(moduleCost.equals("")) break;
            String[] modeleCostArr = moduleCost.split(",");
            cost.put(modeleCostArr[0], Integer.valueOf(modeleCostArr[1]));
            if(modeleCostArr.length > 2){
                List<String> list = new ArrayList<>();
                for(int i = 2; i < modeleCostArr.length; i ++){
                    list.add(modeleCostArr[i]);
                }
                depends.put(modeleCostArr[0], new ArrayList<>(list));
            }
        }

        sc.close();

        //开始
        Queue<String> q = new LinkedList<>();
        q.offer(target);
        visted.add(target);
        int time = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            int max = 0;
            for(int i = 0; i < sz; i ++){
                String cur = q.poll();
                max = Math.max(max, cost.get(cur));
                if(depends.containsKey(cur)){
                    List<String> d = depends.get(cur);
                    for(int k = 0; k < d.size(); k ++){
                        if(!visted.contains(d.get(k))){
                            if(!cost.containsKey(d.get(k))){
                                System.out.println(-1);
                                return;
                            }
                            q.offer(d.get(k));
                            visted.add(d.get(k));
                        } else{
                            System.out.println(-1);
                            return;
                        }
                }

                }
            }
                time += max;
        }
        System.out.println(time);
        return;
    }
}
