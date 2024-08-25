package Nums.Interval;

// 删除被覆盖区间
// 区间问题: 先排序(排序很重要一定要想好怎么排序), 然后分情况讨论

import java.util.Arrays;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        // 按照起点升序, 起点相同则按终点降序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        // 记录合并区间的起点和终点
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int  i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (left <= interval[0] && right >= interval[1]) {   // 完全覆盖
                res++;
            } else if (right >= interval[0] && right <= interval[1]) {   // 部分覆盖
                // 由于排序, 可以只更新 right, 当然这里更新 left 与完全不相交逻辑重合也可以
                right = interval[1];
            } else if (right < interval[0]) {    // 完全不相交
                left = interval[0];
                right = interval[1];
            }
        }
        return intervals.length - res;
    }

    public int removeCoveredIntervalsPro(int[][] intervals) {
        // 按照起点升序, 起点相同则按终点降序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        // 记录合并区间的起点和终点
        int left = intervals[0][0];
        int right = intervals[0][1];
        int ans = intervals.length;
        for (int  i = 1; i < intervals.length; i++) {
            if (left <= intervals[i][0] && right >= intervals[i][1]) {
                ans--;
            } else {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return ans;
    }
}
