class LowestCommonAncestor{
  
  //查找一个结点是否存在与一颗树中
    public boolean search(Node root,Node n){
        if(root == null) {
            return false;
        }
        if (root == n){
            return true;
        }
        if (search(root.left,n)) {
            return true;
        }
        return search(root.right,n);
    }
    //查找两棵树的公共祖先
    public Node lowestCommonAncestor(Node root, Node p, Node q){
        if(root == p || root == q) {
            return root;
        }

        boolean pInLeft = search(root.left,p);
        boolean qInLeft = search(root.left,q);
        //如果两棵树结点都在左子树中，去左子树中找公共祖先
        if(pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left,p,q);
        }
        //如果两棵树结点都在右子树中，去右子树中找公共祖先
        if(!pInLeft && !qInLeft) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}