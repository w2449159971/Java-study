class  JudgeCompleteBinaryTree{ 
//判断是否为完全二叉树
   public static boolean isComplete(Node root) {
        if(root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //将每个结点按照层序遍历压入队列
        //依次从队列中将结点弹出  直至遇见空结点
        while(true) {
            Node front = queue.poll();
            if(front == null) {
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }
        //判断剩下队列中是否存在不是空的结点
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node != null) {
                return false;
            }
        }
        return true;
    }
}