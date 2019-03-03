package Fundation;

public class MyStack {
    //栈的底层使用数组来存储数据。
    int[] elements;
    public MyStack(){
        elements = new int[0];
    }
    //压栈
    public void  push(int element){
        int[] newArr = new int[elements.length + 1];
        System.arraycopy(elements, 0, newArr, 0, elements.length);
        newArr[elements.length] = element;
        elements = newArr;
    }
    //出栈
    public int pop(){
        if (elements.length==0){
            throw new RuntimeException("栈内元素为空！");
        }
        int element = elements[elements.length-1];
        int [] newArr = new int[elements.length-1];
        System.arraycopy(elements, 0, newArr, 0, elements.length-1);
        elements = newArr;
        return element;
    }
    public int peek(){
        if (elements.length==0){
            throw new RuntimeException("栈内元素为空！");
        }
        return elements[elements.length-1];
    }
    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(9);
        ms.push(8);
        ms.push(7);
        System.out.println(ms.peek());
        System.out.println(ms.pop());
        System.out.println(ms.peek());
        System.out.println(ms.pop());
        System.out.println(ms.peek());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
    }
}
