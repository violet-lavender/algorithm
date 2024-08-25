package Sort.Basic;

public class QuickSort {

    public void quickSort(int[] arr, int left , int right){
        if(left < right){
            int p = partition(arr, left, right);
            quickSort(arr,left,p-1);
            quickSort(arr,p+1,right);
        }
    }

    private int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                Swap.swap(arr, i, j);
            }
        }
        Swap.swap(arr, i+1, right);
        return i+1;
    }
}
