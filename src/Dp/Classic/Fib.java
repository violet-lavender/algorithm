package Dp.Classic;

// 斐波那契 —— 简单的 dp 动态规划思想
public class Fib {

    // 状态转移方程, 暴力递归, 有大量的重复计算
    public int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    // 借助备忘录(一般为数组或哈希表), 消除冗余重复
    public int fib2(int n) {
        int[] meno = new int[n + 1];
        return dp(meno, n);
    }

    private int dp(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        // 状态方程为 memo[n] = memo[n - 1] + memo[n - 2], 借助dp实现递归和状态转移方程
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    // 上述为自顶向下的 dp —— 递归实现, 下面为自底向上的 dp —— 迭代实现
    public static int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 每次状态转移方程的更新只用到两个状态, 只需要 dp1, dp2 即可而不必 dp 数组
    public static int fib4(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int dp1 = 1, dp2 = 0;
        for (int i = 2; i <= n; i++) {
            int dp_i = dp1 + dp2;
            dp2 = dp1;
            dp1 = dp_i;
        }
        return dp1;   //最后 dp1、dp2 都多更新了一次, 所以返回搭配 dp1
    }
}
