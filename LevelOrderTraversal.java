class LevelOrderTraversal{
    //层序遍历
    public static void levelOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        //将每个结点按照一层一层的顺序压入队中
        //依次出队就得到二叉树的层序遍历结果
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            Node front = queue.poll();
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }
    }
}