package TX_WXG;

public class Question_1 {


    //实现链表重组
    public Node transform(Node node){
        Node midNode = getMid(node);
        Node reverseNode = reverse(midNode);
        Node newHead = merge(node, reverseNode);
        return newHead;
    }


    // 寻找中间节点
    public Node getMid(Node node){
       Node ptrSlow = node;
       Node ptrFast = ptrSlow.next;
       while(ptrFast != null && ptrFast.next != null){
           ptrFast = ptrFast.next.next;
           ptrSlow = ptrSlow.next;
       }
       Node next = ptrSlow.next;
       ptrSlow.next = null;
       return next;
    }

    // 将链表逆序
    public Node reverse(Node node){
        Node newHead = new Node();
        newHead.next = null;
        Node cur = node;
        while(cur != null){
            Node ptr = cur;
            cur = cur.next;
            ptr.next = newHead.next;
            newHead.next = ptr;
        }
        return newHead.next;
    }

    // 合并两个链表,将链表进行合并
    public Node merge(Node node1, Node node2){
       Node newHead = new Node();
       Node cur = newHead;
       Node ptr1 = node1;
       Node ptr2 = node2;
       while(ptr1 != null && ptr2 != null){
           cur.next = ptr1;
           cur = cur.next;
           ptr1 = ptr1.next;
           cur.next = ptr2;
           cur = cur.next;
           ptr2 = ptr2.next;
       }

       if(ptr1 == null){
           cur.next = ptr2;
       } else{
           cur.next = ptr1;
       }
       return newHead.next;
    }


    public void printNode(Node node){
        Node ptr = node;
        while(ptr != null){
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }


    public static void main(String[] args) {
        Question_1 q = new Question_1();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

       Node node = q.getMid(n1);
       Node node2 = q.reverse(node);
       Node node3 = q.merge(n1, node2);
       q.printNode(node3);
    }
}


class Node{
    public Node(){

    }

    public Node(int val){
        this.val = val;
    }

    int val;
    Node next;
}