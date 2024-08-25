package Nums.NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    // 经典的两数之和, 排序 + 双指针, NSum 问题的通用解法
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

    // 两数之和, 答案唯一
    public int[] twoSum1(int[] nums, int target){
        // 键值对为值和索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target- nums[i]))
                return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return new int[0];
    }

    // 两数之和, 有序数组, 且答案唯一, 要求常数空间
    public int[] twoSum2(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while(l < r){   //找一对值,与二分查找不同,l<r
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                return new int[]{l + 1, r + 1};
            }else if(sum < target){     //sum过小则增大
                l++;
            }else{      //sum过大则调小
                r--;
            }
        }
        return new int[]{-1,-1};
    }
}
