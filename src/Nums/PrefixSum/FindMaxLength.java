package Nums.PrefixSum;

import java.util.HashMap;

// 连续数组. 给定一个二进制数组nums, 找到含有相同数量的0和1的最长连续子数组, 并返回该子数组的长度
// 将0看做-1, 则变成寻找和为0的最长子数组, 即 preSum[i] - preSum[j] == 0
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
        // 前缀和到索引的映射
        HashMap<Integer, Integer> volToIndex = new HashMap<>();
        int res = 0;
        for (int i = 0; i < preSum.length; i++){
            if(!volToIndex.containsKey(preSum[i]))
                volToIndex.put(preSum[i], i);
            // preSum[i] - preSum[j] == 0, 前缀和出现过则找到一个和为0的子数组
            else
                res = Math.max(res, i - volToIndex.get(preSum[i]));
        }
        return res;
    }
}
