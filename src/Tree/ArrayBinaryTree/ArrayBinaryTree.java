package Tree.ArrayBinaryTree;

import java.util.Arrays;

public class ArrayBinaryTree {
    //顺序存储的二叉树
    int[] data;
    public ArrayBinaryTree(int[] data){
        this.data =data;
    }

    public void hierarchicShow() {
        System.out.println(Arrays.toString(data));
    }

    public void frontShow() {
        int i =0;
        print_element(i);
    }

    private void print_element(int i) {
        if(i>data.length-1){
            return;
        }
        System.out.print(data[i]+" ");
        if (data.length>2*i+1){
            print_element(2*i+1);

        }
        if(data.length>2*i+2){
            print_element(2*i+2);
        }

    }
}
