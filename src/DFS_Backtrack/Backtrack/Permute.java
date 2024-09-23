package DFS_Backtrack.Backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 排列问题
public class Permute {

    // 元素无重不可复选
    // 通过保证元素之间的相对顺序不变防止使用重复元素, 显然是不可行的, 需要借助 used[] 辅助数组
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }

    // 元素可重不可复选
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrackUnique(nums, track, used);
        return res;
    }

    private void backtrackUnique(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝逻辑: 保证相同元素在排列中的相对位置不变, 2‘ 只有在 2 已经被使用的情况下才会被选择, 同理 2'' 只有在 2' 已经被使用的情况下才会被选择
            // 同理 use[i] 也可, 相当于维护了 2'' -> 2' -> 2 的相对顺序, 但!used[i-1] 比 used[i-1] 剪枝效率高
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrackUnique(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }

    // 元素无重可复选
    // 标准的全排列算法通过 used[] 数组避免使用重复元素, 去除 used[] 数组剪枝逻辑即可

}
