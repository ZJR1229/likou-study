package meituan;

import java.util.*;

public class Questio_2 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site, list);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<Integer>();
        for (int bus : rec.getOrDefault(source, new ArrayList<Integer>())) {
            dis[bus] = 1;
            que.offer(bus);
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int bus : rec.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[bus] != -1) {
                ret = Math.min(ret, dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }


    public static void main(String[] args) {
        Questio_2 m = new Questio_2();
        Scanner sc = new Scanner(System.in);
        // 站点，车次
        int numSta = sc.nextInt();
        int numLine = sc.nextInt();
        List<List<Integer>> routes = new ArrayList<>();
        for(int i = 0; i <= numLine; i ++){
            routes.add(new ArrayList<>());
        }
        for(int i = 1; i <= numSta; i ++){
            int numBus = sc.nextInt();
            for(int k = 0; k < numBus; k ++){
                int line = sc.nextInt();
                routes.get(line).add(i);
            }
        }

        //将routes转化为数组
        int[][] routesArr = new int[numLine][];
        for(int i = 0; i < routesArr.length; i ++){
            int[] route = new int[routes.get(i + 1).size()];
            for(int k = 0; k < routes.get(i + 1).size(); k ++){
                route[k] = routes.get(i + 1).get(k);
            }
            routesArr[i] = route;
        }

        int[][] res = new int[numSta + 1][numSta + 1];
        for(int i = 1; i < res.length; i ++){
            for(int j = i; j < res.length; j ++){
                res[i][j] = m.numBusesToDestination(routesArr, i, j);
                res[j][i] = res[i][j];
            }
        }

        // 输出
        for(int i = 1; i < res.length; i ++){
            for(int j = 1; j < res.length - 1; j ++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println(res[i][res.length - 1]);
        }
    }
}
