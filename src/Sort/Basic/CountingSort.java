package Sort.Basic;

public class CountingSort {

    public void countingSort(int[] arr) {
        if (arr == null || arr.length  <= 1) {
            return;
        }
        int max = arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        // 将 min ~ max 映射到 count 数组的 0 ~ (max - min) 位置上
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
    }
}
