package Dp.Classic;

// 爬楼梯
public class ClimbStairs {

    public int climbStairs(int n) {
        // 爬上 n 阶的方法数为 dp[n]
        int[] dp = new int[n + 1];
        // base case, 爬上第 0 阶有 1 种方法, 爬上第 1 阶有 1 种方法
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
