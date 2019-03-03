package Tree.ThreadedBinaryTree;

public class TestThreadedBinaryTree {
    public static void main(String[] args) {
        //创建一颗树
        ThreadedBinaryTree binTree = new ThreadedBinaryTree();
        //创建一个根节点
        ThreadedNode root = new ThreadedNode(1);
        //把根节点赋给树
        binTree.setRoot(root);
        ThreadedNode rootL = new ThreadedNode(2);
        ThreadedNode rootR = new ThreadedNode(3);

        root.setLeftNode(rootL);
        root.setRightNode(rootR);
        rootL.setLeftNode(new ThreadedNode(4));
        ThreadedNode fiveNode = new ThreadedNode(5);
        rootL.setRightNode(fiveNode);
        rootR.setLeftNode(new ThreadedNode(6));
        rootR.setRightNode(new ThreadedNode(7));

        binTree.frontShow();
        System.out.println("");
        binTree.midShow();
        System.out.println("");
        binTree.afterShow();
        System.out.println("\n---------------------");
        //前序查找
        ThreadedNode result = binTree.frontSearch(5);
        System.out.println(result);
        //在二叉树中删除某节点
        binTree.delete(62);
        binTree.frontShow();
        //binTree的中序遍历
        System.out.println("\n-----------中序遍历二叉树--------------");
        binTree.midShow();
        System.out.println("\n-----------中序线索化二叉树--------------");
        binTree.threadNodes();

        //最开始要获取节点5所在的节点，但是没法退出递归，会报堆栈溢出的异常
//        ThreadedNode fiveNode = binTree.frontSearch(5);
        //获取节点5的后继节点
//        ThreadedNode afterFive = fiveNode.rightNode;
        //查看节点5的后继节点的值,如果为1则认为线索化正确
//        System.out.println(afterFive.value);
        //遍历线索二叉树的结果应该与中序遍历一样，因为代码中写的是中序遍历二叉树
        System.out.println("遍历线索二叉树");
        binTree.threadIterate();


    }
}
