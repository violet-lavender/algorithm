package Stack_Queue.MonotonicStack;

import java.util.Stack;

// 单调栈. 单调栈常用于解决涉及"最近比当前元素大/小的元素"的问题. ("下一个" —— 倒序遍历; "前一个" —— 正序遍历)
/* 单调递增栈: 栈内元素按从栈底到栈顶递增排序, 即栈顶元素总是大于等于栈底元素,
当遇到一个比栈顶元素小的元素时, 将栈顶元素弹出, 直到栈顶元素小于等于当前元素或者栈为空 */

// 单调栈能够获取局部相邻元素信息, 适合处理"最近一次"、"下一个"、"前一个"等相关问题,
// 而单调队列能够在一定范围内获取全局最值信息, 适合处理滑动窗口最值、动态区间查询问题

/* 数据结构(栈和队列)单调性与求解问题的特性相反, 下一个更大元素需要用单调递减栈, 滑动窗口最大值需要单调递减队列.
单调递减栈: 通过递减性, 帮助找到右侧的"下一个更大元素";
单调递减队列: 通过递减性, 始终保持队头是当前范围内的最大值. */

/* 严格性问题: 是否严格单调还是要看具体问题.
如, 下一个更大元素需要严格单调, 而滑动窗口最大值不需要严格单调. */
public class MonotonicStack {

    // 下一个更大的元素. 单调递减栈
    public int[] calculateGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        // "下一个" —— 倒序遍历; "前一个" —— 正序遍历
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
