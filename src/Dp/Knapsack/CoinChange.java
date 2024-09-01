package Dp.Knapsack;

// 零钱兑换
public class CoinChange {

    // 完全背包问题. 装法总数
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // 背包容量为 0 时只有一种方案, 即不装
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= amount; w++) {
                if (w < coins[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = dp[i - 1][w] + dp[i][w - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}
