package Nums.NSum;

import java.util.*;

public class ThreeSum {

    // 三数之和, 固定 fist, 从从小到大枚举 second, 从大到小枚举 third
    public List<List<Integer>> threeSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            if (first <= n - 3 && nums[first] + nums[first + 1] + nums[first + 2] > target)
                break;
            if (nums[first] + nums[n - 2] + nums[n - 1] < target)
                continue;
            int second = first + 1, third = n - 1;
            int target_ = target - nums[first];
            for (; second < third; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                // 只要能保证first和second不重复, third自然就不会重复, 即这一步骤并不是必须的
                while (third < n - 1 && third > second && nums[third] == nums[third + 1])
                    third--;
                while (second < third && nums[second] + nums[third] < target_)
                    second++;
                while (second < third && nums[second] + nums[third] > target_)
                    third--;
                if (second == third)
                    break;
                if (nums[second] + nums[third] == target_)
                    res.add(List.of(nums[first], nums[second], nums[third]));
            }
        }
        return res;
    }
}
