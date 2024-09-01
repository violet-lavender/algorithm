package Dp.Classic;

import java.util.Arrays;

// 零钱兑换 —— 最优子结构
public class CoinChange {

    public int coinChange1(int[] coins, int amount) {
        return dp1(coins, amount);
    }

    // 定义 dp 函数: 要凑出金额 n, 至少需要 dp(coins, n) 个硬币.
    // 状态转移方程: dp(n) = min(dp(n-coin) + 1), coin ∈ coins[i](选择)
    // 边界条件: dp(0) = 0, dp(-1) = -1
    public static int dp1(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp1(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    // 设置备忘录, 消除重复冗余
    int[] memo;

    public int coinChange2(int[] coins, int amount) {
        memo = new int[amount + 1];
        // 初始化为不可能被取到的特殊值, 表示未被计算
        Arrays.fill(memo, -2);
        return dp2(coins, amount);
    }

    private int dp2(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp2(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    // 自底向上, 迭代法.
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 要求Min, 初始化为一个不可能取到的大值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                // 选与不选, 也是个背包
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
