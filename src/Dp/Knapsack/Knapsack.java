package Dp.Knapsack;

// 背包问题
public class Knapsack {

    // 0 - 1 背包问题. 最大价值
    public int knapsack1(int W, int N, int[] wt, int[] val) {
        // dp[i][w]定义, 对于前 i (从 1 开始计数)个物品, 当前背包的总容量为 w, 这情况下可以装的最大价值是 dp[i][w].
        // 注意 i 从 1 开始计数, 所以长度为 N + 1, 最大可到 N; 而 w 最大值可到达 W , 即重量装满, 所以长度为 W + 1.
        // base case: N = 0 或 W = 0 时, dp 为 0, 即dp[0][w] = 0, dp[i][0] = 0.
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w < wt[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 不装入或者装入, 择优.
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

    // 0 - 1 背包问题. 装法总数
    public int knapsack2(int W, int N, int[] wt) {
        // dp[i][w]定义, dp[i][w] 表示前 i 个物品在容量为 w 的背包中的装法总数
        int[][] dp = new int[N + 1][W + 1];
        // 初始化第一行, 背包容量为0时, 装法总数为1, 即不装
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w < wt[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 不装入和装入, 装法总和
                    dp[i][w] = dp[i - 1][w] + dp[i - 1][w - wt[i - 1]];
                }
            }
        }
        return dp[N][W];
    }

    // 完全背包问题. 最大价值
    public int knapsack3(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w < wt[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 完全背包问题中每种物品可以重复选择, 所以还要考虑选择当前物品后背包容量变为w - wt[i - 1]的情况,
                    // 在选择当前物品时, 物品的序号保持为i(而不是 i - 1), 表明可以重复选择当前物品
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i][w - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

    // 完全背包问题. 装法总数. 与 0 - 1 背包问题装法总数基本一致, 状态转移方程改为完全背包问题即可.
}
