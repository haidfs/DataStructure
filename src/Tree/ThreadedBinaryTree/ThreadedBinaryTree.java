package Tree.ThreadedBinaryTree;

/*
对线索二叉树的概述，二叉树可以看成是一个单数据域双指针域的链表，二叉树而言，所有叶子节点的指针域都为空，存在一定的浪费
为了充分利用内存空间，使每一个节点的指针域都得到充分利用，使得指向前驱或后继，不出现null。
如果左指针为空就指向前驱节点，右指针为空则指向后继节点。
 */
public class ThreadedBinaryTree {
    //类内变量为根节点
    ThreadedNode root;
    ThreadedNode pre;

    //设置根节点
    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    public ThreadedNode getRoot() {
        return root;
    }

    //前序遍历
    public void frontShow() {
        root.frontshow();
    }

    //中序遍历
    public void midShow() {
        root.midShow();
    }

    //后序遍历
    public void afterShow() {
        root.afterShow();
    }

    //前序查找
    public ThreadedNode frontSearch(int i) {
        return root.frontSearch(i);
    }
    //对于树而言，由于树拥有左子树和右子树，很多时候都是分两部分进行左右递归！
    //简单思考下递归的方式和跳出递归的条件

    //删除子树
    public void delete(int i) {
        if (i == root.value) {
            root = null;
        } else {
            root.delete(i);
        }
    }

    public void threadNodes() {
        threadNodes(root);
    }

    public void threadNodes(ThreadedNode node) {
        //处理左子节点
        if (node == null) {
            return;
        }
        threadNodes(node.leftNode);
        //处理自己

        //最初思路是左子节点为空，则指向中序遍历的前一个，中序遍历的前一个节点与根节点相同，所以用临时变量来保存。
        //如果右子节点为空，则指向中序遍历的后一个节点，对于中序遍历叶子节点的后一个节点并不在当前子树内，没法简单获取。
        //所以采用这样的思路：如果上一个节点的右指针为空，则让上一个节点的右指针指向自己
        if (node.leftNode == null) {
            node.leftType=1;
            node.leftNode = pre;
        }
        if (pre != null && pre.rightNode == null) {
            pre.rightType=1;
            pre.rightNode = node;
        }
        pre = node;
        //处理右子节点
        threadNodes(node.rightNode);
    }

    public void threadIterate() {
        ThreadedNode node =root;

        while (node!=null){
            while (node.leftType==0){
                node=node.leftNode;
            }
            System.out.print(node.value+" ");
            while (node.rightType==1){
                node=node.rightNode;
                System.out.print(node.value+" ");
                //如果当前节点指向的是后继节点 ，后继还有可能后继
            }
            node=node.rightNode;


        }

    }
}
