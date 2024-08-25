package Nums.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 合并区间
public class Merge {

    // 返回 int[][] 一般可以构造 list<int[][]>, 最后返回 res.toArray(new int[res.size()][])
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        // 排序, 起点升序即可
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = res.get(res.size() - 1);
            if (cur[0] <= last[1]) {
                // 数组是引用类型, 可以直接复制更改
                last[1] = Math.max(last[1], cur[1]);
            } else {
                res.add(cur);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
