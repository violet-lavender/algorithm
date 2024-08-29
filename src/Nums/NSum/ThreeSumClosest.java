package Nums.NSum;

import java.util.Arrays;

// 最接近的三数之和
public class ThreeSumClosest {

    // 与 threeSum 很像, 但需要一个一个枚举, 双指针只能缓慢移动, 不能通过 while 快速滑动
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                // 不判断是否重复的效率甚至高于判断…… 可以在内层循环开始时判断, 也可以在 second、third 更新时判断
                int sum = nums[first] + nums[second] + nums[third];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum > target) {
                    third--;
                } else if (sum < target) {
                    second++;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }
}
