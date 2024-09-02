package Dp.Classic;

// 完全平方数, 和为 n 的完全平方数的最少数量
public class NumSquares {

    public int numSquares(int n) {
        // 最少需要 dp[i] 个完全平方数表示 i; base case: dp[0] = 0
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int tmp = Integer.MAX_VALUE;
            // 枚举到 j * j <= i 即可
            for (int j = 1; j * j <= i; j++) {
                tmp = Math.min(tmp, dp[i - j * j]);
            }
            dp[i] = tmp + 1;
        }
        return dp[n];
    }
}
