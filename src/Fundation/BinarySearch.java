package Fundation;

public class BinarySearch {
    public static void main(String[] args) throws Exception {
        //二分查找的前提是数组有序
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int begin = 0;
        int end = arr.length - 1;
        int mid = (begin + end) / 2;
        int target = 18;
        while (arr[mid] != target) {
            if (begin >= end){
                throw new Exception("目标元素不在数组中，请重新输入！");
            }
            if (arr[mid] < target) {
                begin = mid + 1;
                mid = (begin + end) / 2;
            } else {
                end = mid - 1;
                mid = (begin + end) / 2;
            }
        }
        System.out.println(mid);

    }
}
