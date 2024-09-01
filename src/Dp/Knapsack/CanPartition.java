package Dp.Knapsack;

// 分割等和子集
public class CanPartition {

    // 子集背包问题. N 个物品, 可转载重量为 sum / 2, 是否能恰好装满.
    // 用 boolean 记录 dp 更合适, 通过或运算, 只要过程中出现一个 true, 就可以一直传递下来, 提高效率
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        // 和为奇数肯定不行
        if (sum % 2 == 1)
            return false;
        sum = sum / 2;
        // dp[i][w], 对于前 i(从 1 开始计数)个物品, 当前背包的总容量为 w, 是否能将背包恰好装满
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case, 重量为 0 时, 肯定可以装满
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= sum; w++) {
                if (w < nums[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 不装入或装入
                    dp[i][w] = dp[i - 1][w] || dp[i - 1][w - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
