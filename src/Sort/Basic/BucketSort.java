package Sort.Basic;

import java.util.ArrayList;
import java.util.Collections;

// 桶排序
// 映射函数人为设计, 但要保证桶 i 中的数均小于桶 j （i < j）中的数. 即必须桶间必须有序, 桶内可以无序, 可以考虑按照数的区间范围划分桶.
public class BucketSort {

    public void bucketSort(int[] arr) {
        if (arr == null || arr.length  <= 1){
            return;
        }
        int max= arr[0], min= arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        // 这里桶映射函数为 (i - min) / arr.length
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] - min) / arr.length;
            buckets.get(index).add(arr[i]);
        }
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(buckets.get(i));
        }
        int k = 0;
        for (int i = 0; i < bucketNum; i++) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                arr[k++] = buckets.get(i).get(j);
            }
        }
    }
}
