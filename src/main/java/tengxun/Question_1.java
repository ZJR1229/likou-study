package tengxun;

public class Question_1 {
    public ListNode solve (ListNode[] a) {
        // 头节点
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        //
        ListNode[] cur = new ListNode[a.length];
        // 定义指针
        for(int i = 0; i < a.length; i ++){
            cur[i] = a[i];
        }
        //
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < a.length; i ++){
                if(cur[i] != null){
                    flag = true;
                    ptr.next = cur[i];
                    cur[i] = cur[i].next;
                    ptr = ptr.next;
                }
            }
        }
        return head.next;
    }
}




class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
    this.val = val;
    }
}
