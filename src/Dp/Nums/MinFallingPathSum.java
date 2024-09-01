package Dp.Nums;

import java.util.Arrays;

// 下降路径最小和
// dp[i][j]: 从第一行落到位置 (i, j) 的最小路径和
public class MinFallingPathSum {

    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];
        for (int[] m : memo)
            Arrays.fill(m, Integer.MAX_VALUE);
        for (int j = 0; j < n; j++)
            // 终点可能在最后一行的任意一列
            res = Math.min(res, dp(matrix, n - 1, j));
        return res;
    }

    // dp: 从第一行落到位置 (i, j) 的最小路径和, 对于 (i, j), 有三种可能来的地方 (i - 1, j - 1), (i - 1, j), (i - 1, j + 1)
    public int dp(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return Integer.MAX_VALUE;
        // base case
        if (i == 0)
            return matrix[i][j];
        if (memo[i][j] != Integer.MAX_VALUE)
            return memo[i][j];
        memo[i][j] = matrix[i][j] + Math.min(dp(matrix, i - 1, j - 1),
                Math.min(dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1)));
        return memo[i][j];
    }

    // 迭代法, 直接 dp 数组
    public int minFallingPathSum_(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[0][i] = matrix[0][i];
        for (int i = 1; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 求 dp[i][j], 可能来的地方(i - 1, j - 1),(i - 1, j),(i - 1, j + 1), 注意 j - 1, j + 1 可能越界
                dp[i][j] = matrix[i][j] + dp[i - 1][j];
                if (j - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i - 1][j - 1]);
                if (j + 1 < n)
                    dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i - 1][j + 1]);
            }
        }
        for (int i = 0; i < n; i++)
            res = Math.min(res, dp[n - 1][i]);
        return res;
    }
}
