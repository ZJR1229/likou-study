package algorithm;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = newHead.next;
            newHead.next = tmp;
        }

        return newHead.next;


    }


    public int[] MySort (int[] arr) {
        quickSort(arr, 0 , arr.length - 1);
        return arr;
    }

    public void quickSort(int[] arr, int left, int right){
        if(left > right){
            return;
        }

        int l = left;
        int r = right;
        int key = arr[left];
        while(l < r){
            while(arr[r] >= key && l < r){
                r --;
            }

            while(arr[l] <= key && l < r){
                l ++;
            }

            if(l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        arr[left] = arr[l];
        arr[l] = key;
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }
}



class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}