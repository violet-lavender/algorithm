package Sort;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length <= 1)
            return;
        for(int i = arr.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++)
                if(arr[j] < arr[j + 1])
                    Swap.swap(arr, j, j + 1);
        }
    }
}
