package Dp.Nums;

import java.util.Arrays;

// 最大子数组和
// 子串(子数组)是连续的, 而子序列则不一定连续.
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int res = nums[0], pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }
}
