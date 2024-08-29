package Nums.PrefixSum;

// 区域和检索 —— 数组不可变, 前缀和数组.
// 前缀和 preSum = new int[nums.length + 1], preSum[i + 1] 为 nums 的前 i 项之和( 0~n 共 n+1 个)
// 在前缀和数组中, preSum[i] - preSum[j], 即表示 i, j 之间的子数组之和
// 一般我们让 preSum 比 nums 数组多一位, 因为第一位要放 0
public class NumArray {
    private int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for(int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
