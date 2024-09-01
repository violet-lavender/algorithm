package Dp.Nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 最长递增子序列(LIS)问题.
// 子串(子数组)是连续的, 而子序列则不一定连续.
public class LIS {

    // DP
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度.(初始化为 1)
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 二分
    /* 设 f[j] 表示 nums 前 i 个元素可以组成的长度为 j 的最长严格递增子序列的末尾元素的最小值, 如果不存在长度为 j 的最长严格递增子序列, 对应的 f 值无定义.
    在定义范围内, 可以看出 f 值是严格单调递增的, 因为越长的子序列的末尾元素显然越大.
    在进行状态转移时, 考虑当前的元素 nums[i]:
     如果 nums[i] > f ，那么 nums[i] 就可以接在 f 中的最大值之后, 形成一个长度更长的严格递增子序列;
     否则我们找出 f 中比 nums[i] 严格小的最大的元素 f[j0], 即f[j0] < nums[i] < f[j0 + 1], 那么 nums[i] 可以接在 f[j] 之后, 形成一个长度为 j0+1 的严格递增子序列,
      因此需要对 f[j0+1] 进行更新: f[j0 + 1] = nums[i]. 可以在 f 上进行二分查找, 找出满足要求的 j0(j0 + 1).
        (j0 是小于 nums[i] 的最大值的索引(right), 而 j0+1 是大于 nums[i] 的最小值的索引(left))
    在遍历所有的 nums[i]后, f 中最后一个有定义的元素的下标增加 1(下标从 0 开始)即为最长严格递增子序列的长度. */
    public int lengthOfLISPlus(int[] nums) {
        List<Integer> f = new ArrayList<>();
        f.add(nums[0]);
        for (int num : nums) {
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    // j0+1: 大于 nums[i] 的最小值的索引(left), 注意是严格大于
    private int binarySearch(List<Integer> f, int num) {
        int left = 0, right = f.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 俄罗斯套娃信封问题, 对宽度升序排序, 宽度相同时按高度降序排序, 对高度数组做 LIS
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];
        return lengthOfLISPlus(height);
    }
}
