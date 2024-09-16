package Sort.Basic;

// 快排优化思路:
// 1. 随机基准
// 2. 三数取中法. 取数组的第一个、最后一个、中间元素三个数中的中间数作为基准
// 3. 当待排序序列的长度分割到一定大小后, 使用插入排序
// 4. 三路划分. 第一部分小于基准 v, 第二部分等于基准v, 第三部分大于基准v
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

    // 三路划分
    public void quickSort3(int[] arr, int left, int right) {
        if (left < right) {
            int[] p = partition3(arr, left, right);
            quickSort3(arr, left, p[0] - 1);
            quickSort3(arr, p[1] + 1, right);
        }
    }

    private int[] partition3(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1, j = right + 1;
        int cur = left;
        while (cur < j) {
            if (arr[cur] < pivot) {
                Swap.swap(arr, ++i, cur++);
            } else if (arr[cur] > pivot) {
                // 此时 cur 指针不能前移, 交换到cur位置的元素来自未知区域, 还需要进一步判断 array[cur].
                Swap.swap(arr, --j, cur);
            } else {
                cur++;
            }
        }
        return new int[]{i + 1, j - 1};
    }
}
