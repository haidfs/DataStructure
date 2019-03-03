package Tree.ArrayBinaryTree;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        int[] data =new int[]{1,2,3,4,5,6,7};
        ArrayBinaryTree abTree = new ArrayBinaryTree(data);
        abTree.hierarchicShow();
        abTree.frontShow();
    }
}

