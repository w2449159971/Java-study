

 //判断树是否为为平衡树（左右子树高度差的绝对值小于等于1）
class BalancedTree{
    public int height(Node root) {
     //判断高度
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
//         int height = Math.max(left,right);
//         return height + 1;
       return left>right?left+1:right+1;
    }

    public boolean isBalanced(Node root) {
     //如果一个空树是平衡树
        if(root == null){
            return true;
        }
        //左右子树也必须满足平衡树
        boolean leftBalanced = isBalanced(root.left);
        if(!leftBalanced){
            return false;
        }
        boolean rightBalanced = isBalanced(root.right);
        if(!rightBalanced){
            return false;
        }

       //判断左右子树结点绝对值相差小于等于1
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diff = leftHeight - rightHeight;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return true;
    }

}
