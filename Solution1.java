class ListNode {
      int val;
      ListNode next;
      ListNode(int x)
      {
          val = x;
          next = null;
      }
}

public class Solution1{
    //删除链表中给定值的结点
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

        //1.遍历链表比较结点值与给定值
        ListNode cur = head.next;
        ListNode prev = head;

        //2.若与给定值相等 删除节点
        while(cur != null ){
            if(cur.val == val) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }

        if(head.val == val) {
            head = head.next;
        }

        return head;
    }

    public static ListNode partition(ListNode head, int val){
        //将小于给定数字的节点放在该数字之前
        ListNode small = null;
        ListNode smallLast = null;
        ListNode big = null;
        ListNode bigLast = null;

        ListNode cur = head;
        //遍历链表
        while(cur != null) {
            if(cur.val < val) {
               //cur尾插到small
                if (small == null) {
                    small = cur;
                } else {
                    smallLast.next = cur;
                }
                smallLast = cur;
            } else {
                //尾插到big
                if (big == null) {
                    big = cur;
                } else {
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
            cur = cur.next;
        }

        //将big与small连在一起
        if(small == null){
            return big;
        } else {
            smallLast.next = big;
        }
        if (big == null) {
            return small;
        } else {
            bigLast.next = null;
        }
        return small;
    }

    private static ListNode creatList(){
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(8);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(3);
        ListNode n8 = new ListNode(2);
        ListNode n9 = new ListNode(3);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        n5.next = n6; n6.next = n7; n7.next = n8; n8.next = n9;
        return n1;
    }

    public static void print(ListNode head){
        ListNode cur = head;
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
        ListNode head = creatList();
        print(head);

        head = removeElements(head, 8);
        head = removeElements(head, 6);
        print(head);

        ListNode newhead = partition(head, 5);
        print(newhead);
    }
}