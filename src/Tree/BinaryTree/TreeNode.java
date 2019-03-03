package Tree.BinaryTree;

public class TreeNode {
    int value;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }
    //设置左儿子

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }
    //设置右儿子

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    //前序遍历 中序遍历 后序遍历
    public void frontShow() {
        System.out.print(value + " ");
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }

    }

    public void midShow() {
        if (leftNode != null) {
            leftNode.midShow();
        }
        System.out.print(value + " ");
        if (rightNode != null) {
            rightNode.midShow();
        }

    }

    public void afterShow() {
        if (leftNode != null) {
            leftNode.afterShow();
        }
        if (rightNode != null) {
            rightNode.afterShow();
        }
        System.out.print(value + " ");

    }

    public TreeNode frontSearch(int i) {
        //节点的前序查找和前序遍历实质上是一样的
        TreeNode target = null;
        if (this.value == i) {
            return this;
        } else {
            if (leftNode != null) {
                target = leftNode.frontSearch(i);
            }
            if (target != null) {
                return target;
            }
            if (rightNode != null) {
                target = rightNode.frontSearch(i);
            }
        }
        return target;
    }


    //删除一颗子树
    public void delete(int i) {
        TreeNode parent = this;
        if (parent.leftNode != null && parent.leftNode.value == i) {
            parent.leftNode = null;
            return;
        }
        if (parent.rightNode != null && parent.rightNode.value == i) {
            parent.rightNode = null;
            return;
        }
        parent = leftNode;
        if (parent != null) {
            parent.delete(i);
        }
        parent = rightNode;
        if (parent != null) {
            parent.delete(i);
        }

    }
}
