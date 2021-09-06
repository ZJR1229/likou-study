//package TX_WXG;
//
//public class Question_2 {
//    private void QuickSort(int[] num, int left, int right) {
//        if(left >= right){
//            return;
//        }
//
//        int l = left;
//        int r = right;
//        int key = num[left];
//
//        while(l < r){
//            // 右边向前移
//            while(num[r] >= key && l < r){
//                r --;
//            }
//
//            // 左边向后移
//            while(num[l] <= key && l < r){
//                l ++;
//            }
//
//            // 进行置换
//            if(l < r) {
//                int temp = num[l];
//                num[l] = num[r];
//                num[r] = temp;
//            }
//        }
//        num[left] = num[l];
//        num[l] = key;
//        QuickSort(num, left, l - 1);
//        QuickSort(num, l + 1, right);
//    }
//
//    public void printArr(int[] arr){
//        for(int i = 0; i < arr.length; i ++){
//            System.out.println(arr[i]);
//        }
//    }
//
//
//    // 获取倒数第k个节点
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        ListNode pre = head;
//        ListNode post = head;
//        for(int i = 0; i < k; i ++){
//            post = post.next;
//        }
//        while(post != null){
//            pre = pre.next;
//            post = post.next;
//        }
//        return pre;
//    }
//
//    public static void main(String[] args) {
//        Question_2 q = new Question_2();
//        int[] arr = new int[]{2, 4, 1, 6, 5, 9, 0};
//        q.QuickSort(arr, 0, arr.length - 1);
//        q.printArr(arr);
//    }
//}
//
//
//
// class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//  }
//
