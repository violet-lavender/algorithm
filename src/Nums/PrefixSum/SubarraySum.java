package Nums.PrefixSum;

import java.util.HashMap;

// 和为k的子数组, preSum[i] - preSum[j] == k
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        // 这里不需要用数组, 维护一个变量记录最新的前缀和即可
        int preSum = 0;
        // 前缀和到该前缀和出现次数的映射
        HashMap<Integer, Integer> count = new HashMap<>();
        // 注意要把初始化时要把 (0, 1) 放进去, 否则单个元素无法添加
        count.put(0, 1);
        for (int i = 1; i < n + 1; i++) {
            preSum += nums[i - 1];
            int need = preSum - k;
            if (count.containsKey(need))
                res += count.get(need);
            count.put(preSum, count.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
