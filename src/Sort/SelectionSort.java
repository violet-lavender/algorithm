package Sort;

public class SelectionSort {
    public static void selectSort(int[] arr){
        if(arr == null || arr.length <= 1)
            return;
        for(int i = 0; i < arr.length - 1; i++){
            int index = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[index])
                    index = j;
            }
            Swap.swap(arr, i, index);
        }
    }
}
