class Node{
    public int val;
    public Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

public class MergeTwoLinkedList {
    //合并两个有序链表
    public static Node merge(Node head1,Node head2) {
        Node c1 = head1;
        Node c2 = head2;
        Node newhead = null;
        Node last = null;

        if (head1 == null) newhead = head2;
        if (head2 == null) newhead = head1;

        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {

                if (newhead == null) {
                    newhead = c1;
                    last = newhead;
                } else {
                    last.next = c1;
                    last = last.next;
                }
                c1 = c1.next;
            } else {
                if (newhead == null) {
                    newhead = c2;
                    last = newhead;
                } else {
                    last.next = c2;
                    last = last.next;
                }
                c2 = c2.next;
            }
        }
        if(c1 != null){
            last.next = c1;
        } else {
            last.next = c2;
        }
        return newhead;
    }

    public static Node creatlist1(){
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static Node creatlist2(){
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(5);
        Node n4 = new Node(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static void print(Node head){
        Node cur = head;
        while (cur != null){
            if(cur.next == null){
                System.out.printf("%d ",cur.val);
            }
            else{
                System.out.printf("%d ->",cur.val);
            }
            cur = cur.next;
        }
        System.out.println( );
    }

    public static void main(String[] args) {
        Node head1 = creatlist1();
        Node head2 = creatlist2();
        print(head1);
        print(head2);

        Node newhead = merge(head1 , head2);
        print(newhead);
    }
}