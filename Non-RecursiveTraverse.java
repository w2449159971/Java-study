import java.util.*;

class Node{
    char val;  //结点值
    Node left = null;  //指向左孩子   或代表左孩子为根的整个左子树
    Node right = null; //指向右孩子   或代表右孩子为根的整个右子树
    Node (char val) {
        this.val = val;
    }
}

public class Non-RecursiveTraverse{
 //前中后序非递归写法
    /*非递归  vs   递归
     栈空间更容易控制
     递归使用的栈是系统调用栈,空间较小，一般大小比较固定
     非递归实现栈，栈的空间在堆上，一般比较大
     */

//前序
    public static void preorderNoR(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            Node top = stack.pop();
            cur = top.right;
        }
    }

//中序
    public static void inorderNoR(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
    }

//后序
    public static void postorderNoR(Node root) {
        //后序遍历  即按结点被第三次经过的先后顺序遍历输出
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        //表示上一个被三次经过的结点
        Node last = null;
        while(!stack.empty() || cur != null) {
            //首先不断压入左孩子
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //当结点左孩子为空  判断它是否为满足输出条件
            Node top = stack.peek();
            if (top.right == null || top.right == last) {
                stack.pop();
                System.out.println(top.val);
                last = top;
            } else {
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        Node root = buildTree();
        preorderNoR(root);
        System.out.println(   );
        inorderNoR(root);
        System.out.println(   );
        postorderNoR(root);
    }

    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;

        return a;
    }
}
