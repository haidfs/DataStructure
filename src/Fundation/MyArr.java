package Fundation;

import java.util.Arrays;

public class MyArr {
    private int[] arr;

    public MyArr() {
        arr = new int[]{1, 2, 3, 4, 5};
    }

    private void add(int position, int element) {
        if (position < 0 || position > arr.length) {
            System.out.println("The argumnet position " + position + " is illegal!");
            return;
        }
        int[] temp = new int[arr.length + 1];
        System.arraycopy(arr, 0, temp, 0, position);
        temp[position] = element;
        System.arraycopy(arr, position, temp, position + 1, arr.length - position);
        System.out.println(Arrays.toString(temp));
    }
    private void delete(int position){
        if (position < 1 || position > arr.length) {
            System.out.println("The argumnet position " + position + " is illegal!");
            return;
        }
        int [] temp = new int[arr.length-1];
        System.arraycopy(arr, 0, temp, 0, position-1);
        System.arraycopy(arr, position, temp, position -1, arr.length - position);
        System.out.println(Arrays.toString(temp));
    }

    public static void main(String[] args) {
        MyArr add1 = new MyArr();
        add1.add(0, 12);
        add1.add(5, 12);
        add1.delete(5);
    }
}
