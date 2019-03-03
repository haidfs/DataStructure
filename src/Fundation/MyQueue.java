package Fundation;

import java.util.Arrays;

public class MyQueue {
    //底层使用数组存储
    int[] elements;
    public MyQueue(){
        elements = new int[0];
    }

    //入队
    public MyQueue enqueue(int element){
        int[] newArr = new int[elements.length+1];
        System.arraycopy(elements,0,newArr,0,elements.length);
        newArr[elements.length]= element;
        elements = newArr;
        return this;
    }
    //出队
    public void dequeue(){
        if (elements.length==0){
            throw new RuntimeException("队列长度为0，不可出队");
        }
        peek();
        int[] newArr=new int[elements.length-1];
        System.arraycopy(elements,1,newArr,0,elements.length-1);
        elements = newArr;

    }
    //查看队首元素
    public void peek(){
        if (elements.length==0){
            throw new RuntimeException("队列长度为0，无队首元素");
        }
        System.out.println("队首元素是："+elements[0]);

    }
    //打印队列
    public void show(){
        System.out.println(Arrays.toString(elements));
    }

    public static void main(String[] args) {
        MyQueue mq =new MyQueue();
        mq.enqueue(1).enqueue(2);
        mq.dequeue();
        mq.show();
    }

}
