package Tree.BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        //创建一颗树
        BinaryTree binTree = new BinaryTree();
        //创建一个根节点
        TreeNode root = new TreeNode(1);
        //把根节点赋给树
        binTree.setRoot(root);
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(3);

        root.setLeftNode(rootL);
        root.setRightNode(rootR);
        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));
        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));

        binTree.frontShow();
        System.out.println("");
        binTree.midShow();
        System.out.println("");
        binTree.afterShow();
        System.out.println("\n---------------------");
        //前序查找
        TreeNode result = binTree.frontSearch(5);
        System.out.println(result);
        //在二叉树中删除某节点
        binTree.delete(62);
        binTree.frontShow();


    }
}
