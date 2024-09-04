package Dp.Nums;

// 不同路径. 从左上顶点到右下顶点, 只能向下或者向右
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        // 到达 (m, n) 的路径总数
        int[][] dp = new int[m][n];
        // base case: 第一列和第一行, 只能一直向下或一直向右 —— 一种路径
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 只能来自上、左
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
