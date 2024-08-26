package Stack_Queue.MonotonicQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 滑动窗口最大值, 可以看到在滑动窗口内的 k 个数字
public class MaxSlidingWindow {

    // 借助单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先“填满” k - 1
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}

