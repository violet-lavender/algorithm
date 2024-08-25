package Nums.SubArray;

// 最大子数组和
// 滑动窗口、DP、前缀和、分治都可以
// 滑动窗口: 在窗口内元素之和大于等于 0 时扩大窗口, 小于 0 时缩小窗口, 在每次移动窗口时更新答案
   // 元素和最大的子数组一定是以正数开头的(以负数开头的话, 把这个负数去掉可以得到一个和更大的子数组, 矛盾), 所以穷举所有以正数开头的子数组
// DP: 定义 dp[i] 为以 nums[i] 结尾的最大子数组和, dp[i] = max(dp[i-1]+nums[i], nums[i]), 再进一步空间压缩
// 前缀和: 显然 preSum[i+1] - preSum[j] 即为 nums[j...i] 之和, 那么以 nums[i] 结尾的最大子数组之和则为 preSum[i+1] - min(preSum[0...i])
// TODO 分治: 类似于线段树操作, 不太会, 后续学到线段树补充
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // base case
        int dp_0 = nums[0];
        int dp_1 = 0, res = dp_0;
        // dp
        for (int i = 1; i < n; i++) {
            dp_1 = Math.max(dp_0 + nums[i], nums[i]);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }
        return res;
    }

    // 官解就更加巧妙简洁了
    public int maxSubArrayPro(int[] nums) {
        int res = nums[0], pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }
}
