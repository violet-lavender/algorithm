package Stack_Queue.MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

// 柱状图中最大的矩形.
public class LargestRectangleArea {

    // 单调栈. 对于某个柱子 height[i], 以它为高, 找到最大宽度即可, —— 前一个更小的元素和下一个更小的元素.(两个索引之间, 双开区间)
    // 再考虑没有时如何处理, 没有下一个更小的元素时, 右侧最大宽度可以延申到 length - 1, 双开区间, 计 length, 同理左侧计 -1
    public int largestRectangleArea(int[] heights) {
        int res = Integer.MIN_VALUE;
        int[] pre = preSmallerElement(heights);
        int[] nxt = nextSmallerElement(heights);
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nxt[i] - pre[i] - 1);
            res = Math.max(res, area);
        }
        return res;
    }

    // 下一个更小的元素 —— 记录索引. 没有则计 n
    private int[] nextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return res;
    }

    // 上一个更小的元素 —— 记录索引. 没有则计 -1
    private int[] preSmallerElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }
}
