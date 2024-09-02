package Dp.Nums;

// 乘积最大子数组
public class MaxProduct {

    // 错误逻辑, 没有考虑负数情况.
    public int maxProductFalse(int[] nums) {
        int n = nums.length;
        // 以 nums[i] 结尾的最大子数组(乘积)为 dp[i]
        int[] dp = new int[n];
        dp[0] = nums[0];
        // res 初始化为 nums[0], n == 0 时可以返回正确结果
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            // 将 nums[i] 接在子数组后, 或者成为新的子数组, 即以 nums[i] 结尾的乘积最大子数组
            dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 考虑负数的情况(负数时希望前面负得更多, 即更小), 再维护一个以 nums[i] 结尾的最小子数组(乘积)
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int res = dpMax[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], nums[i]), dpMin[i - 1] * nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], nums[i]), dpMin[i - 1] * nums[i]);
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }
}
