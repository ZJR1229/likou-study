package 链表;

import java.util.*;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
  }

public class Solution {
    /**
     *
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        // 反转链表
        ListNode reverseNode1 = reverse(head1);
        ListNode reverseNode2 = reverse(head2);
        // 结果链表
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode cur1 = reverseNode1;
        ListNode cur2 = reverseNode2;
        int numG = 0;
        int numS = 0;
        while(cur1 != null && cur2 != null){
            int sum = cur1.val + cur2.val + numS;
            numG = sum % 10;
            numS = sum / 10;
            ListNode tmp = new ListNode(numG);
            tmp.next = head.next;
            head.next = tmp;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        ListNode cur = new ListNode(0);
        if(cur1 == null){
            cur = cur2;
        } else{
            cur = cur1;
        }

        while(cur != null){
            int sum = cur.val + numS;
            numG = sum % 10;
            numS = sum / 10;
            ListNode tmp = new ListNode(numG);
            tmp.next = head.next;
            head.next = tmp;
            cur = cur.next;
        }

        if(numS != 0){
            ListNode tmp = new ListNode(numS);
            tmp.next = head.next;
            head.next = tmp;
        }

        return head.next;
    }


    // 反转链表
    public ListNode reverse(ListNode node){
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        ListNode cur = node;
        while(cur != null){
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = newHead.next;
            newHead.next = tmp;
        }
        return newHead.next;
    }


    // 输出
    public void printListNode(ListNode head){
        ListNode cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        ListNode n21 = new ListNode(6);
        ListNode n22 = new ListNode(3);

        n21.next = n22;
        n22.next = null;

//        ListNode res = s.addInList(n1, n21);
        // 测试反转
        ListNode res = s.addInList(n1, n21);
        s.printListNode(res);
        }
}