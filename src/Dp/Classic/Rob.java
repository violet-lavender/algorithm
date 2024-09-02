package Dp.Classic;

// 打家劫舍
public class Rob {

    public int rob(int[] nums) {
        int n = nums.length;
        // 前 i 个元素偷取的最高金额为 dp[i]. 注意下标, 第 i 个元素为 nums[i - 1].
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
