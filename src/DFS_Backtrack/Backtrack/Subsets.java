package DFS_Backtrack.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 子集问题
public class Subsets {

    // 元素无重不可复选
    // 通过保证元素之间的相对顺序不变, 防止出现重复的子集
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 通过 start 控制元素的相对顺序不变, 防止出现重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    // 元素可重不可复选
    // 先排序, 让相同的元素靠在一起, 如果发现 nums[i] == nums[i-1], 则跳过
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrackWithDup(nums, 0);
        return res;
    }

    private void backtrackWithDup(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑, 值相同的相邻树枝, 只遍历第一条
            // i > start, 去除了 i = start, 保证剪掉的是值相同的左右相邻树枝, 而不是值相同的上下相邻树枝(这是合法的)
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            track.add(nums[i]);
            backtrackWithDup(nums, i + 1);
            track.removeLast();
        }
    }
}
