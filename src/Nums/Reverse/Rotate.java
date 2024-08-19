package Nums.Reverse;

import Nums.PrefixSum.PreSum;

// 轮转数组
public class Rotate {

    // 环状替换, 巧妙的交换与迭代
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= nums.length;
        // 需要遍历次数为k和n的最大公约数
        int count = gcd(k, n);
        for (int start = 0; start < count; start++) {
            int cur = start;
            int prev = nums[start];
            do {
                int nxt = (cur + k) % n;
                int tmp = nums[nxt];
                nums[nxt] = prev;
                prev = tmp;
                cur = nxt;
            } while (start!= cur);
        }
    }

    private int gcd(int a, int b) {
        return b == 0? a : gcd(b, a % b);
    }

    // 数组反转, 巧妙的数学技巧
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    // 双闭区间
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
