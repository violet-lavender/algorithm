package Nums.SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 滑动窗口最大值
public class MaxSlidingWindow {

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

// 单调队列
class MonotonicQueue {
    LinkedList<Integer> maxQueue = new LinkedList<>();

    // 注意入队时, 要把比 num 小的元素推掉, 保持“单调”
    public void push(int num) {
        while (!maxQueue.isEmpty() && num > maxQueue.getLast()) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(num);
    }

    public int max() {
        return maxQueue.getFirst();
    }

    // 注意出队时, 要判断 num == maxQueue.getFirst(), 因为想删除的元素可能已经被推出了
    public void pop(int num) {
        if (maxQueue.getFirst() == num) {
            maxQueue.pollFirst();
        }
    }
}