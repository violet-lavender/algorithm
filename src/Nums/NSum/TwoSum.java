package Nums.NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    // 排序 + 双指针, NSum问题的通用解法
    public List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int first = 0, second = n - 1;
        for (; first < second; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            while (second < n - 1 && first < second && nums[second] == nums[second + 1])
                second--;
            while (first < second && nums[first] + nums[second] < target)
                first++;
            while (first < second && nums[first] + nums[second] > target)
                second--;
            if (first == second)
                break;
            if (nums[first] + nums[second] == target)
                res.add(List.of(nums[first], nums[second]));
        }
        return res;
    }
}
