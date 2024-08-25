package Nums.NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    // 固定 first、second, third 从小到大, forth 从大到小, 加入更多的条件判断与剪枝逻辑, 降低时间复杂度
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n < 4)
            return null;
        Arrays.sort(nums);
        for(int first = 0; first < n - 3; first ++){
            if(first > 0 && nums[first] == nums[first - 1])
                continue;
            if((long) nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target)
                break;
            if((long) nums[first] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target)
                continue;
            for(int second = first + 1; second < n - 2; second++){
                if(second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                if((long) nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target)
                    break;
                if((long) nums[first] + nums[second] + nums[n - 1] + nums[n - 2] < target)
                    continue;
                int third = second + 1;
                int forth = n - 1;
                for(; third < n - 1; third++){
                    if(third > second + 1 && nums[third] == nums[third - 1])
                        continue;
                    while(third < forth && (long)nums[first] + nums[second] + nums[third] + nums[forth] > target)
                        forth--;
                    if(third == forth)
                        break;
                    if((long)nums[first] + nums[second] + nums[third] + nums[forth] == target){
                        res.add(List.of(nums[first], nums[second], nums[third], nums[forth]));
                    }
                }
            }
        }
        return res;
    }
}
