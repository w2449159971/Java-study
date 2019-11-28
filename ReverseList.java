
class Node{
    public int val;
    public Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

public class ReverseList {
    public static Node reverse(Node head){
        Node newhead = null;
        Node cur = head;
        //从头结点开始将向后一个节点的指向逆置过来
        while(cur != null){
            Node next = cur.next;
            cur.next = newhead;
            newhead = cur;
            cur = next;
        }
        return newhead;
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

    public static Node creatlist(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public  static void main(String[] args){
        Node list = creatlist();
        print(list);
        Node newlist = reverse(list);
        print(newlist);
    }
}
