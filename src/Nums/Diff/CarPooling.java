package Nums.Diff;

//拼车. 给出上车站点、下车站点、人数, 判断是否超载. 差分
public class CarPooling {

    // 注意 [start,end), end 时已经下车, 所以是左开右闭区间, 即 [start, end - 1]
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];     // 题目要求最多 1000 个车站
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            if (trip[2] < 1001)
                diff[trip[2]] -= trip[0];
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] + diff[i];
            if (diff[i] > capacity)
                return false;
        }
        return diff[0] <= capacity;
    }
}
