import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


//1.纯key模型： set
//2.key-value模型： map
public class BinarySearchTree {
    private static class Node{
        int key;
        int value;

        Node left;
        Node right;
    }

    private Node root = null;

    /**
     *  查找
     * @param key  关键字
     * @return     找到了返回对应的value，如果没找到，返回-1
     */
    public int get (int key) {
        Node cur = root;
        while (cur != null) {
            if (key == cur.key) {
                return cur.value;
            } else if(key < cur.value) {
                cur = cur.right;
            }
        }

        return -1;
    }

    public int put(int key, int value) {
        if(root == null) {
            root = new Node();
            root.key = key;
            root.value = value;
            return -1;
        }

        Node parent = null;
        Node cur = root;
        while(cur != null) {
            if (key == cur.key) {
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            } else if (key < cur.key){
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }

        Node node = new Node();
        node.key = key;
        node.value = value;

        if (key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        return -1;
    }

    //如果key存在，返回其value
    //如果key不存在，返回-1
    public int remove(int key) {
        //先查找
        Node parent = null;
        Node cur = root;
        while(cur != null) {
            if (key == cur.key) {
                //要删除cur
                int oldValue = cur.value;
                deleteNode(parent,cur);
                return oldValue;
            } else if(key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }

        return -1;
    }

    private void deleteNode(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            }
            if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }
            if (cur == parent.left) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            Node goat = cur.left;
            Node goatParent = cur;
            while(goat.right != null) {
                goatParent = goat;
                goat =goat.right;
            }
            //goat 是比cur小的值中最大的一个
            cur.key = goat.key;
            cur.value = goat.value;

            if (goat == goatParent.left) {
                goatParent.left = goat.left;
            } else {
                goatParent.right = goat.left;
            }
        }
    }

    public int getOrDefult(int key, int defaultValue) {
        if (root == null) {
            return defaultValue;
        }
        Node cur = root;
        while(cur != null) {
            if (key == cur.key) {
                return cur.value;
            } else if(key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return defaultValue;
    }

    public Set<Integer> keySet(){
        Set<Integer> result = new HashSet<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node front = queue.poll();
            result.add(front.key);
            if (front.left != null){
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
        return result;
    }

    public Set<Integer> keySet2(){
        Set<Integer> set = new HashSet<>();
        inorderTraversal(set,root);
        return set;
    }

    //键值对 class
    public static class Entry {
        private int key;
        private int value;

        public int getKey() {
            return key;
        }
        public int getValue() {
            return value;
        }
    }

    //public Set<Map.Entry<Integer, Integer>> entrySet()
    //返回所有的键值对
    public Set<Entry> entrySet1() {
        Set<Entry> set = new HashSet<>();
        if (root == null) {
            return set;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            Entry entry = new Entry();
            entry.key = front.key;
            entry.value = front.value;
            set.add(entry);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
        return set;
    }

    public Set<Entry> entrySet2() {
        Set<Entry> set = new HashSet<>();
        inorderTraversalEntry(set,root);
        return set;
    }

    private static void inorderTraversalEntry(Set<Entry> set, Node root ){
        if (root != null) {
            inorderTraversalEntry(set,root.left);
            Entry entry = new Entry();
            entry.key = root.key;
            entry.value = root.value;
            set.add(entry);
            inorderTraversalEntry(set,root.right);
        }
    }

    private static void inorderTraversal(Set<Integer> set, Node root) {
        if (root != null) {
            inorderTraversal(set,root.left);
            set.add(root.key);
            inorderTraversal(set,root.right);
        }
    }

    private static void inorderPrint(Node root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.println(root.key);
            inorderPrint(root.right);
        }
    }

    private static void preorderPrint(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preorderPrint(root.left);
            preorderPrint(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] keys = { 6, 7, 4, 2, 1, 5, 9, 3, 8 };
        for (int key : keys) {
            tree.put(key, key + 100);
        }
        //前序 + 中序
        preorderPrint(tree.root);
        System.out.println("===================");
        inorderPrint(tree.root);
        System.out.println("===================");

        System.out.println(tree.get(3));
        System.out.println(tree.get(13));
        System.out.println(tree.getOrDefult(130, 1123));
        System.out.println(tree.keySet());
    }
}
