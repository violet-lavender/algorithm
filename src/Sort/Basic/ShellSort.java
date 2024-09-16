package Sort.Basic;

// 希尔排序. 将整个待排元素序列分割成 gap 个增量为 gap 的子序列, 然后对每个子序列进行插入排序.
public class ShellSort {

    public void shellSort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; i >= gap && arr[i - gap] > temp; i -= gap) {
                    arr[i] = arr[i - gap];
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }
}
