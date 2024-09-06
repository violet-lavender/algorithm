package Trick.Greed;

import java.util.Arrays;

// 跳跃游戏. 数组中的每个元素代表在该位置可以跳跃的最大长度
public class Jump {

    // 判断是否能够到达最后一个下标
    // 对于每一个可到达的位置 x, x + 1, x + 2, ... x + nums[x]都可达, 维护最远可到达的位置即可
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightBound = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightBound) {
                rightBound = Math.max(rightBound, i + nums[i]);
                if (rightBound >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // 到达 nums[n - 1] 的最小跳跃次数(用例保证可到 nums[i - 1])
    // 贪心, 从最后一个位置开始考虑, 每次选择离当前位置最远的那个位置
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int res = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                // i 是正向的, 第一个可到达的肯定是最远的
                if (i + nums[i] >= position) {
                    position = i;
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    // 正向贪心, 考虑当前路径和下一步最远路径
    public int jumpPro(int[] nums) {
        int n = nums.length;
        // [start, end), 左闭右开
        int start = 0, end = 1;
        int res = 0;
        while (end < n) {
            int maxPosition = 0;
            for (int i = start; i < end; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
            }
            start = end;
            end = maxPosition + 1;
            res++;
        }
        return res;
    }

    // DP, 性能很差
    public int jumpFalse(int[] nums) {
        int n = nums.length;
        // dp[i]: 到达 nums[i] 的最小跳跃次数
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}