class Node{
    char val;  //结点值
    Node left = null;  //指向左孩子   或代表左孩子为根的整个左子树
    Node right = null; //指向右孩子   或代表右孩子为根的整个右子树

    Node (char val) {
        this.val = val;
    }
}

public class Trees {
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

//前序遍历
    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

//中序遍历
    public static void inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

//后序遍历
    public static void postOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        preOrderTraversal(root);
        System.out.println(   );
        inOrderTraversal(root);
        System.out.println(   );
        postOrderTraversal(root);
    }
}