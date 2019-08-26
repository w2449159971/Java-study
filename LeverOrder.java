class LeverOrder{

//包装一个类用于保存结点和其层数
 private static class Element{
        Node node;
        int level;
        Element(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static List<List<Character>> levelOrder(Node root) {
        List<List<Character>> retList = new ArrayList<>();

        if(root == null) {
            return retList;
        }
        //队列中存放的是结点与其层数
        Queue<Element> queue = new LinkedList<>();
        Element e = new Element(root, 0);
        queue.add(e);
        while(!queue.isEmpty()) {
            Element front = queue.poll();
           //根据层数将队中的结点放入不同的线性表中
            if (front.level == retList.size()) {
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add(front.node.val);
            if (front.node.left != null) {
                Element l = new Element(front.node.left,front.level + 1);
                queue.add(l);
            }
            if (front.node.right != null) {
                Element r = new Element(front.node.right,front.level + 1);
                queue.add(r);
            }
        }
        return retList;
    }
}