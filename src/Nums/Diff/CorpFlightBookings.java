package Nums.Diff;

// 航班预订统计.
public class CorpFlightBookings {

    int[] diff;

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        diff = new int[n];
        for (int[] booking : bookings) {
            // 记录和编号都是从 1 开始,转换成数组索引时要 -1
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            increment(i, j, val);
        }
        // 根据差分数组反解数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++)
            res[i] = res[i - 1] + diff[i];
        return res;
    }

    private void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length)
            diff[j + 1] -= val;
    }

    // 没有给定原数组, 只定义一个差分数组进行迭代即可, 不用定义函数更新diff即可
    public int[] corpFlightBookingsPro(int[][] bookings, int n) {
        diff = new int[n];
        for (int[] booking : bookings) {
            diff[booking[0] - 1] += booking[2];
            if (booking[1] < n)
                diff[booking[1]] -= booking[2];
        }
        for (int i = 1; i < n; i++)
            diff[i] = diff[i] + diff[i - 1];
        return diff;
    }
}
