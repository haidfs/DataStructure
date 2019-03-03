package Sort;

import java.util.Arrays;

public class Sort {
    int[] arr = new int[]{1,6,7,2,4,13,22313,243241,222,31321,22,11,4324,1231};
    private int[] sort(int[] arr){
        for (int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    arr[i] = arr[i]^arr[j];
                    arr[j]= arr[i]^arr[j];
                    arr[i] = arr[i]^arr[j];
                }
            }
        }
        return arr;
    }

    private  int[] insertSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            if (arr[i]<arr[i-1]){
                int itemToInsert =arr[i];
                int j;
                for (j=i-1;j>=0&&arr[j]>itemToInsert;j--){
                    arr[j+1]=arr[j];
                }
                arr[j+1]=itemToInsert;
            }
        }
        return arr;
    }

    private int[] shellSort(int[] arr){
        //遍历所有步长
        for (int d=arr.length/2;d>0;d/=2){
            //遍历子数组的第一个元素
            for (int i=0;i<d;i++){
                //对单个子数组中的所有元素进行插入排序
                for(int j=i;j<arr.length-d;j+=d){
                    if(arr[j]>arr[j+d]){
                        int temp = arr[j];
                        arr[j] =  arr[j+d];
                        arr[j+d] = temp;
                    }
                }
            }
        }
        return arr;
    }

    private int[] selectSort(int[] arr){
        for(int i=0;i< arr.length;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            //if(minIndex!=i){
//                arr[i] = arr[i]^arr[minIndex];
//                arr[minIndex]= arr[i]^arr[minIndex];
//                arr[i] = arr[i]^arr[minIndex];
            int temp = arr[i];
            arr[i] =  arr[minIndex];
            arr[minIndex] = temp;
            // }


        }
        return arr;
    }

    private int[] heapSort(int[] arr){
        //构建大根堆
        for (int i =arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //交换首尾与调整堆结构
        for (int j =arr.length-1;j>0;j--){
            swap(arr,0,j);
            //只有根节点的小二叉树不满足大根堆，所以直接用0做一个调整即可
            adjustHeap(arr,0,j-1);
        }
        return arr;

    }

    private static void adjustHeap(int[] arr,int start,int end){
        int root = start;
        int child;
        while (true){
            child = root * 2 +1;
            if (child>end){
                break;
            }
            if ((child+1)<end && arr[child]< arr[child+1]){
                child +=1;
            }
            if (arr[root]<arr[child]){
                swap(arr,root,child);
                //在本身存在多层的情况下，例如root是一个三层树的根的情况下，root<子节点<孙节点，所以需要赋给子节点，子节点再和孙节点进行交换
                root = child;
            }
            else {
                break;
            }
        }

    }

    private void swap(int a,int b){
        a=a^b;
        b=a^b;
        a=a^b;
    }

    private static void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] =arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Sort s=new Sort();
        //int[] arr1 =s.sort(s.arr);
        int[] arr2 = s.heapSort(s.arr);
        //System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
}