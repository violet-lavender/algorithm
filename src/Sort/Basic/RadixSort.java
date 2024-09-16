package Sort.Basic;

import java.util.ArrayList;

// 基数排序
// 基数排序是按照低位先排序, 然后收集; 再按照高位排序, 然后再收集; 依次类推, 直到最高位.
// 有时候有些属性是有优先级顺序的, 先按低优先级排序, 再按高优先级排序. 最后的次序就是高优先级高的在前, 高优先级相同的低优先级高的在前.
public class RadixSort {

    public void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 先计算最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int maxDigit = 0;
        while (max > 0) {
            max /= 10;
            maxDigit++;
        }
        int div = 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < maxDigit; i++, div *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digit = (arr[j] / div) % 10;
                buckets.get(digit).add(arr[j]);
            }
            int index = 0;
            for (int j = 0; j < buckets.size(); j++) {
                for (int k = 0; k < buckets.get(j).size(); k++) {
                    arr[index++] = buckets.get(j).get(k);
                }
                buckets.get(j).clear();
            }
        }
    }
}
