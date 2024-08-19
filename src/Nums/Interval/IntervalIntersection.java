package Nums.Interval;

import java.util.ArrayList;
import java.util.List;

// 区间列表的交集
public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new int[][]{};
        }
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int a0 = firstList[i][0], a1 = firstList[i][1];
            int b0 = secondList[j][0], b1 = secondList[j][1];
            // 有交集
            if (b0 <= a1 && b1 >= a0) {
                res.add(new int[]{Math.max(a0, b0), Math.min(a1, b1)});
            }
            // 指针是否前进只取决于右端点, 无论是否有交集指针都要前进
            if (b1 < a1) {
                j++;
            }else {
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
