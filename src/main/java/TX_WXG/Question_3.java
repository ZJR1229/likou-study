package TX_WXG;

import com.sun.javaws.IconUtil;

public class Question_3 {


    // 将链表进行重排
    public ListNode transFrom(ListNode node){
        ListNode mid = getMid(node);
        ListNode reverse = reverse(mid);
        ListNode finalNode = merge(node, reverse);
        return finalNode;
    }


    // 寻找中间节点
    public ListNode getMid(ListNode node){
        ListNode ptrSlow = node;
        ListNode ptrFast = ptrSlow.next;
        while(ptrFast != null && ptrFast.next != null){
            ptrFast = ptrFast.next.next;
            ptrSlow = ptrSlow.next;
        }
        ListNode next = ptrSlow.next;
        ptrSlow.next = null;
        return next;
    }


    // 合并两个链表
    public ListNode merge(ListNode node1, ListNode node2){
        ListNode ptr1 = node1;
        ListNode ptr2 = node2;
        ListNode head = new ListNode();
        ListNode cur = head;
        printListNode(node1);
        printListNode(node2);
        while(ptr1 != null && ptr2 != null){
            cur.next = ptr1;
            ptr1 = ptr1.next;
            cur = cur.next;
            cur.next = ptr2;
            ptr2 = ptr2.next;
            cur = cur.next;
        }
        if(ptr1 == null) cur.next = ptr2;
        else{
            cur.next = ptr1;
        }
        return head.next;
    }


    //链表逆序
    public ListNode reverse(ListNode node){
        ListNode head = new ListNode();
        head.next = null;
        ListNode ptr = node;
        while(ptr != null){
            ptr.next = head.next;
            head.next = ptr;
        }
        printListNode(head.next);
        return head.next;
    }


    // 输出
    public void printListNode(ListNode node){
        ListNode ptr = node;
        while(ptr != null){
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        Question_3 q = new Question_3();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        ListNode node = q.transFrom(n1);
        q.printListNode(node);
    }
}


class ListNode{
    public int val;
    public ListNode next;
    public ListNode(){

    }

    public ListNode(int val){
        this.val = val;
    }
}