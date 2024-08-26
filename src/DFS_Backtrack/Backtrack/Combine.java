package DFS_Backtrack.Backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 组合问题
public class Combine {

    // 元素无重不可复选
    // 与子集问题基本一致, 通过保证元素之间的相对顺序不变, 防止出现重复的组合
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k); // 1 ~ n, 从1开始
        return res;
    }

    private void backtrack(int start, int n, int k) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(i + 1, n, k);
            track.removeLast();
        }
    }

    // 元素可重不可复选
    // 与子集问题基本一致, 排序让相同的元素靠在一起, 如果发现 nums[i] == nums[i-1], 则跳过
    int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtrackSum2(candidates, 0, target);
        return res;
    }

    private void backtrackSum2(int[] nums, int start, int target) {
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            trackSum += nums[i];
            // 进入下一层决策
            backtrackSum2(nums, i+1, target);
            // 撤销选择
            track.removeLast();
            trackSum -= nums[i];
        }
    }

    // 元素无重可复选
    // 标准的子集/组合问题中, i 从 start 开始, 那么下一层回溯树就是从 start+1 开始, 从而保证 nums[start] 不会被重复使用
    // 想要每个元素被重复使用, 只要把 i + 1 改成 i 即可, 此时是一个无限递归树, 要注意结束条件
    // 注意上述逻辑只是针对元素是否可以复选, 这里也是通过 start 变量保证元素之间的相对顺序不变, 防止出现重复的组合
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backtrackSum(candidates, 0, target);
        return res;
    }

    private void backtrackSum(int[] nums, int start, int target) {
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            trackSum += nums[i];
            // 进入下一层决策
            backtrackSum(nums, i, target);
            // 撤销选择
            track.removeLast();
            trackSum -= nums[i];
        }
    }
}
