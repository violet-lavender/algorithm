package Dp.Nums;

// 最小路径和. 非负整数, 从左上顶点到右下顶点, 只能向下或者向右.
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 到达 (m, n) 的最小路径
        int[][] dp = new int[m][n];
        // base case: 第一列和第一行, 只能一直向下或一直向右 —— 一种路径, 路径和直接累加
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 只能来自上、左
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
