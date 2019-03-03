package Tree.ThreadedBinaryTree;


public class ThreadedNode {
    //节点元素类型
    int value;
    ThreadedNode leftNode;
    ThreadedNode rightNode;
    //线索化二叉树需要有一个标记是左右或者前驱/后继节点的类型，默认值为0，默认指向左右子树，个人认为没必要定义直接判断指针域是否为null即可
    int leftType;
    int rightType;


    public ThreadedNode(int value){
        this.value = value;
    }
    public void setLeftNode(ThreadedNode leftNode){
        this.leftNode = leftNode;
    }
    public void setRightNode(ThreadedNode rightNode){
        this.rightNode = rightNode;
    }

    public void frontshow() {
        System.out.print(value+" ");
        if (leftNode!=null){
            leftNode.frontshow();
        }
        if (rightNode!=null){
            rightNode.frontshow();
        }
    }

    public void midShow() {
        if (leftNode!=null){
            leftNode.midShow();
        }
        System.out.print(value+" ");
        if (rightNode!=null){
            rightNode.midShow();
        }
    }

    public void afterShow() {
        if(leftNode!=null){
            leftNode.afterShow();
        }
        if (rightNode!=null){
            rightNode.afterShow();
        }
        System.out.print(value+" ");
    }

    public ThreadedNode frontSearch(int i) {
        ThreadedNode target = null;
        if (value==i){
            return this;
        }
        if (leftNode!=null){
            target=leftNode.frontSearch(i);
        }
        if (target!=null){
            return target;
        }
        if (rightNode!=null) {
            target = rightNode.frontSearch(i);
        }
        return target;
    }

    public void delete(int i) {
        ThreadedNode parent = this;
        if (parent.leftNode!=null&&parent.leftNode.value==i) {
            parent.leftNode = null;
        }
        if (parent.rightNode!=null&&parent.rightNode.value==i){
            parent.rightNode=null;
        }
        parent=leftNode;
        if (parent!=null){
            parent.delete(i);
        }
        parent=rightNode;
        if (parent!=null){
            parent.delete(i);
        }

    }
}