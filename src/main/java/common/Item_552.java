package common;

import java.util.*;

public class Item_552 {
    // 552
    private int mod = 1000000007;
    public int checkRecord2(int n) {
        long[][][] dp = new long[n + 1][2][3];
        dp[0][0][0] = 1;
        for(int i = 1; i <= n; i ++){
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % mod;
            dp[i][0][1] = (dp[i - 1][0][0]) % mod;
            dp[i][0][2] = (dp[i - 1][0][1]) % mod;
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % mod;
            dp[i][1][1] = (dp[i - 1][1][0]) % mod;
            dp[i][1][2] = (dp[i - 1][1][1]) % mod;
        }

        long sum = 0;
        for(int i = 0; i < 2; i ++)
            for(int j = 0; j < 3; j ++){
                sum = (sum + dp[n][i][j]) % mod;
            }
        return (int)sum;
    }


    // 552
    public int checkRecord(int n) {
        int mod = 1000000007;
        long dpPre_0_0 = 1;
        long dpPre_0_1 = 0;
        long dpPre_0_2 = 0;
        long dpPre_1_0 = 0;
        long dpPre_1_1 = 0;
        long dpPre_1_2 = 0;
        long dpPost_0_0 = 0;
        long dpPost_0_1 = 0;
        long dpPost_0_2 = 0;
        long dpPost_1_0 = 0;
        long dpPost_1_1 = 0;
        long dpPost_1_2 = 0;
        for(int i = 1; i <= n; i ++){
            dpPost_0_0 = (dpPre_0_0 + dpPre_0_1 + dpPre_0_2) % mod;
            dpPost_0_1 = dpPre_0_0 % mod;
            dpPost_0_2 = dpPre_0_1 % mod;
            dpPost_1_0 = (dpPre_0_0 + dpPre_0_1 + dpPre_0_2 + dpPre_1_0 + dpPre_1_1 + dpPre_1_2) % mod;
            dpPost_1_1 = dpPre_1_0 % mod;
            dpPost_1_2 = dpPre_1_1 % mod;
            dpPre_0_0 = dpPost_0_0;
            dpPre_0_1 = dpPost_0_1;
            dpPre_0_2 = dpPost_0_2;
            dpPre_1_0 = dpPost_1_0;
            dpPre_1_1 = dpPost_1_1;
            dpPre_1_2 = dpPost_1_2;
        }
        long sum = (dpPost_0_0 + dpPost_0_1 + dpPost_1_0 + dpPost_1_1 + dpPost_0_2 + dpPost_1_2) % mod;
        return (int)sum;

    }

    // 345
    public String reverseVowels2(String s) {
        String vowel = "aeiouAEIOU";
        // 初始化比较数组
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < vowel.length(); i ++){
            list.add(vowel.charAt(i));
        }

        char[] chars = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(!list.contains(chars[left])){
                left ++;
                if(left == chars.length){
                    break;
                }
            }
            while(!list.contains(chars[right])){
                right --;
                if(right == 0){
                    break;
                }
            }

            // 进行交换
            if(left < right){
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
            }
            left ++;
            right --;
        }
        return new String(chars);

    }

    // 345
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String vowel = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(!vowel.contains(String.valueOf(chars[left]))){
                left ++;
                if(left == s.length() - 1){
                    break;
                }
            }

            while(!vowel.contains(String.valueOf(chars[right]))){
                right --;
                if(right == 0){
                    break;
                }
            }

            // 交换
            if(left < right){
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
            }

            left ++;
            right --;
        }
        return new String(chars);
    }


    // 541.反转字符串
    public String reverseStr(String s, int k) {
        // 转化为数组
        char[] chars = s.toCharArray();
        int index = 0;
        // 能处理完一轮
        while((index + 2 * k - 1) <= s.length() - 1){
          reverse(chars, index, index + k);
          index += 2 * k;
        }
        // 长度大于k
        if((chars.length - index) >= k){
            reverse(chars, index, index + k);
        } else{
            reverse(chars, index, chars.length);
        }

        return String.valueOf(chars);
    }

    // 541
    public void reverse(char[] chars, int start, int end){
        int left = start;
        int right = end - 1;
        while(left < right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            right --;
            left ++;
        }
    }

    // 443
    public int compress(char[] chars) {
        int index = 1;
        int alterPos = 0;
        char tag = chars[0];
        int countAll = 0;
        int countSingle = 1;
        while(index < chars.length){
            if(chars[index] == tag){
                countSingle ++;
            } else{
                chars[alterPos] = tag;
                alterPos ++;
                if(countSingle == 1) {
                    countAll += 1;

                } else{
                    countAll += 1 + String.valueOf(countSingle).length();
                    char[] tmp = String.valueOf(countSingle).toCharArray();
                    for(int i = 0; i < tmp.length; i ++){
                        chars[alterPos] = tmp[i];
                        alterPos ++;
                    }
                }
                countSingle = 1;
                tag = chars[index];
            }
            index ++;
        }

        chars[alterPos] = tag;
        alterPos ++;
        if(countSingle == 1){
            return countAll + 1;
        } else{
            char[] tmp = String.valueOf(countSingle).toCharArray();
            for(int i = 0; i < tmp.length; i ++){
                chars[alterPos] = tmp[i];
                alterPos ++;
            }
            return countAll + 1 + String.valueOf(countSingle).length();
        }
    }


    // 746
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        minCost[0] = 0;
        minCost[1] = 0;
        minCost[2] = Math.min(cost[0], cost[1]);
        for(int i = 3; i < minCost.length; i ++){
            minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
        }
        return minCost[minCost.length - 1];
    }


    // 198
    public int rob2(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] moneyMax = new int[nums.length];
        moneyMax[0] = nums[0];
        moneyMax[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i < nums.length; i ++){
            moneyMax[i] = Math.max(moneyMax[i - 1], moneyMax[i - 2] + nums[i]);
        }
        return moneyMax[moneyMax.length - 1];
    }

    // 213
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        // 偷第一家,不算最后一家
        int[] moneyMax = new int[nums.length - 1];
        moneyMax[0] = nums[0];
        moneyMax[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i < moneyMax.length; i ++){
            moneyMax[i] = Math.max(moneyMax[i - 1], moneyMax[i - 2] + nums[i]);
        }
        int max = moneyMax[moneyMax.length - 1];

        // 偷最后一家，不偷第一家
        int[] moneyMax2 = new int[nums.length];
        moneyMax2[1] = nums[1];
        moneyMax2[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < moneyMax2.length; i ++){
            moneyMax2[i] = Math.max(moneyMax2[i -1], moneyMax2[i - 2] + nums[i]);
        }
        int max2 = moneyMax2[moneyMax2.length - 1];
        return Math.max(max, max2);
    }


    // 740
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length; i ++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        int[] numMax = new int[map.size()];
        numMax[0] = list.get(0) * map.get(list.get(0));
        if(list.get(1) - 1 == list.get(0)){
            numMax[1] = Math.max(numMax[0], list.get(1) * map.get(list.get(1)));
        } else{
            numMax[1] = numMax[0] + list.get(1) * map.get(list.get(1));
        }

        if(nums.length == 2){
            return numMax[1];
        }

        for(int i = 2; i < list.size(); i ++){
            if(list.get(i) - 1 == list.get(i - 1)){
                numMax[i] = Math.max(numMax[i - 1], numMax[i - 2] + list.get(i) * map.get(list.get(i)));
            } else{
                numMax[i] = numMax[i - 1] + list.get(i) * map.get(list.get(i));
            }
        }

        return numMax[numMax.length - 1];
    }


    // 789逃脱阻碍者
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = Math.abs(target[0]) + Math.abs(target[1]);
        for(int i = 0; i < ghosts.length; i ++){
            int ghostDist = Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1]);
            if(ghostDist <= dist){
                return false;
            }
        }
        return true;
    }

    // 53 最大子序和
    public int maxSubArray(int[] nums) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        int maxValue = nums[0];
        for(int i = 1; i < nums.length; i ++){
            max[i] = Math.max(nums[i], max[i - 1] + nums[i]);
            if(max[i] > maxValue){
                maxValue = max[i];
            }
        }
        return maxValue;
    }

    // 918
    public int maxSubarraySumCircular(int[] nums) {
        int maxValue = maxSubArray(nums);
        for(int i = 0; i < nums.length - 1; i ++){
            // 移动位置
            int tmp = nums[0];
            for(int k = 0; k < nums.length - 1; k ++){
                nums[k] = nums[k + 1];
            }
            nums[nums.length - 1] = tmp;
            if(maxValue < maxSubArray(nums)){
                maxValue = maxSubArray(nums);
            }
        }
        return maxValue;
    }

    // 55 跳跃游戏
    public boolean canJump(int[] nums) {
        boolean[] flags = new boolean[nums.length];
        flags[0] = true;
        for(int i = 0; i < nums.length - 1; i ++){

            if(flags[i] == true){
                for(int j = 0; j <= nums[i]; j ++){
                    if((i + j) < flags.length){
                        flags[i + j] = true;
                    }

                }
            }

        }
        return flags[flags.length - 1];
    }


    // 881 救生艇
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boatCount = 0;
        while(left < right){
            boatCount ++;
            if( (people[right] + people[left]) <= limit){
                left ++;
                right --;
            } else{
                right --;
            }
        }
        if(left == right){
            return boatCount + 1;
        } else{
            return boatCount;
        }
    }


    // 51 n皇后
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // 初始化
        char[][] chessboard = new char[n][n];
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++){
                chessboard[i][j] = '.';
            }
        traceback(chessboard, 0);
        return res;
    }

    // 表示棋盘当前的状态以及当前处理的行数
    private void traceback(char[][] chessboard, int row){
        for(int i = 0; i < chessboard[0].length; i ++){
            if(isValid(chessboard, row, i)){
                chessboard[row][i] = 'Q';
                if(row == chessboard.length - 1){
                    List<String> list = new ArrayList<>();
                    for(int k = 0; k < chessboard.length; k ++){
                        list.add(String.valueOf(chessboard[k]));
                    }
                    res.add(list);
                }
                traceback(chessboard, row + 1);
                chessboard[row][i] = '.';
            }
        }
    }


    // 检查i， j 坐标是否可以放置东西
    private boolean isValid(char[][] chessboard, int i, int j){
        // 检查同一列
        if(i > 0){
            for(int n = i - 1; n >= 0; n --){
                if(chessboard[n][j] == 'Q')
                    return false;
            }
        }

        // 检查左上
        if(i > 0 && j > 0){
            int row = i - 1;
            int col = j - 1;
            while(row >=0 && col >= 0){
                if(chessboard[row][col] == 'Q'){
                    return false;
                }
                row --;
                col --;
            }
        }


        // 检查右上
        if(i > 0 && j < chessboard.length){
            int row = i - 1;
            int col = j + 1;
            while(row >= 0 && col <chessboard.length){
                if(chessboard[row][col] == 'Q'){
                    return false;
                }
                row --;
                col ++;
            }
        }

        return true;
    }


    // 45 跳跃游戏二
    public int jump(int[] nums) {
        int start = 0;
        int maxDist = 0;
        int step = 0;
        for(int i = 0; i < nums.length - 1; i ++){
            maxDist = Math.max(maxDist, i + nums[i]);
            if(i == start){
                start = maxDist;
                step ++;
            }
        }
        return step;
    }

    // 152
    public int maxProduct(int[] nums) {
        int maxValue = nums[0];
        for(int i  = 1; i < nums.length; i ++){
            nums[i] = Math.max(nums[i], nums[i - 1] * nums[i]);
            if(nums[i] > maxValue){
                maxValue = nums[i];
            }
        }
        return maxValue;
    }

    // 077链表排序
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode head2 = getMid(head);
        sortList(head);
        sortList(head2);
        ListNode newHead = merge(head, head2);
        return newHead;

    }


    // 得到中间节点
    public ListNode getMid(ListNode node){
        ListNode ptrSlow = node;
        ListNode ptrFast = ptrSlow.next;
        while(ptrFast != null && ptrFast.next != null){
            ptrSlow = ptrSlow.next;
            ptrFast = ptrFast.next;
        }
        ListNode next = ptrSlow.next;
        ptrSlow.next = null;
        return next;
    }


    // 将两个链表合并
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode newHead = new ListNode();
        newHead.next = null;
        ListNode cur = newHead;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                cur.next = head1;
                head1 = head1.next;
            } else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 == null){
            cur.next = head2;
        } else{
            cur.next = head1;
        }
        return newHead.next;
    }






    public void printNode(ListNode node){
        ListNode ptr = node;
        while(ptr != null){
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }


    public static void main(String[] args) {
        Item_552 i = new Item_552();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        ListNode node = i.sortList(n1);
        i.printNode(node);

    }
}



 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }





