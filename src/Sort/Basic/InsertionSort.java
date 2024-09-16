package Sort.Basic;

public class InsertionSort {
    public void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        // 每次循环使得 0~i 有序, 有隐式的 break 操作
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j > 0 && arr[j] > arr[j + 1]; j--)
                Swap.swap(arr, j, j + 1);
        }
    }

    // 二分插入排序
    public void binaryInsertionSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        for (int i = 1; i < arr.length; i++) {
            int left = 0, right = i - 1, mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (arr[mid] < arr[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            for (int j = i - 1; j >= left; j--)
                Swap.swap(arr, j, j + 1);
            arr[left] = arr[i];
        }
    }
}
