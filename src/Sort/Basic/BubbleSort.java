package Sort.Basic;

public class BubbleSort {

    // 冒泡排序, 可以设置标识 flag, 提前结束循环
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[j + 1])
                    Swap.swap(arr, j, j + 1);
        }
    }

    // 鸡尾酒排序, 双向冒泡
    public void cocktailSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++)
                if (arr[i] > arr[i + 1])
                    Swap.swap(arr, i, i + 1);
            right--;
            for (int i = right; i > left; i--)
                if (arr[i] < arr[i - 1])
                    Swap.swap(arr, i, i - 1);
            left++;
        }
    }
}
