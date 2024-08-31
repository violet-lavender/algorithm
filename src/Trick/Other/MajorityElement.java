package Trick.Other;

// 多数元素, 即在数组中出现次数大于 n / 2 的元素
public class MajorityElement {
    // Boyer-Moore 投票算法. 把众数记为 +1, 把其他数记为 −1, 将它们全部加起来, 显然和大于 0, 从结果本身可以看出众数比其他数多.
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}