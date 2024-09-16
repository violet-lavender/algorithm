package Sort.Basic;

public class HeapSort {

    public void heapSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        buildMaxHeap(arr);
        // 循环将堆顶(最大值)与堆尾交换, 删除堆尾元素, 然后重新调整大根堆
        while (n > 0) {
            Swap.swap(arr, 0, n - 1);
            n--;
            sink(arr, 0);
        }
    }

    private void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(arr, i);
        }
    }

    private void sink(int[] arr, int i) {
        int n = arr.length;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // 如果最大的节点不是当前节点, 则交换并继续下沉
        if (largest != i) {
            Swap.swap(arr, i, largest);
            sink(arr, largest);
        }
    }
}
