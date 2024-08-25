package Nums.Other;

// 缺失的第一个正数
// 置换 "恢复" 对于一个长度为 N 的数组, 其中没有出现的最小正整数只能在 [1, N+1]
/* 对于 x = nums[i], 如果 x ∈ [1, N], 则 x 应该出现在数组的 x - 1 位置, 则交换 nums[i] 和 nums[x - 1]
在交换完成后, 新的 nums[i] 可能还在 [1, N] 中, 则继续交换, 直到 x 不属于[1, N];
注意如果 nums[i] == nums[x - 1], 则 x 出现在正确位置, 停止交换, 遍历下一个数, 防止死循环 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
