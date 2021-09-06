package algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // 二叉树的深度
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int depth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i ++){
                TreeNode node = q.poll();
                // 停止标记
                if(node.left == null && node.right == null){
                    return depth;
                }

                //遍历
                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }

            }
            depth ++;
        }

        return depth;
    }



    // 815 公交路线
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //
        if(source == target) return 0;

        // 确定最大值
        int maxLen = 0;
        for(int i = 0; i < routes.length; i ++){
            for(int j = 0; j < routes[i].length; j ++){
                if(routes[i][j] > maxLen){
                    maxLen = routes[i][j];
                }
            }
        }
        // 初始化,1表示可以直达
        int[][] graph = new int[maxLen + 1][maxLen + 1];
        for(int i = 0; i < routes.length; i ++){
            for(int j = 0; j < routes[i].length - 1; j ++)
                for(int k = j + 1; k < routes[i].length; k ++){
                    graph[routes[i][j]][routes[i][k]] = 1;
                    graph[routes[i][k]][routes[i][j]] = 1;
                }
        }

        // 开始计算
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(source);
        visited.add(source);
        int dist = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i ++){
                // 到达目的地
                int cur = q.poll();
                if(cur == target) return dist;

                // 遍历相邻节点
                for(int k = 1; k <= maxLen; k ++){
                    // 连通
                    if(graph[cur][k] == 1){
                        if(!visited.contains(k)){
                            q.offer(k);
                            visited.add(k);
                        }
                    }
                }
            }
            dist ++;
        }

        return -1;
    }


    //确定连通分量个数
    public int getConnect(int[][]graph){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < graph.length; i ++){
            if(!visited.contains(i)){
                count ++;
                visited.add(i);
                q.offer(i);
                while(!q.isEmpty()){
                    int sz = q.size();
                    for(int k = 0; k < sz; k ++){
                        int cur = q.poll();
                        if(visited.size() == graph.length){
                            return count;
                        }
                        for(int m = 0; m < graph.length; m ++){
                            if(graph[cur][m] == 1){
                                if(!visited.contains(m)){
                                    visited.add(m);
                                    q.offer(m);
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BFS b = new BFS();
        int[][] graph = new int[][]{{0, 1, 1}, {1, 0, 0}, {1, 0, 0}};
        int count = b.getConnect(graph);
        System.out.println(count);
    }
}


//Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

