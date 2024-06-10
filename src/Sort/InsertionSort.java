package Sort;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length <= 1)
            return;
        // 每次循环使得0~i有序, 有隐式的break操作
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j > 0 && arr[j] > arr[j + 1]; j--)
                Swap.swap(arr, j, j+1);
        }
    }
}
