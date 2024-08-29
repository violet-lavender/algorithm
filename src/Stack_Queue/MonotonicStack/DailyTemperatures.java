package Stack_Queue.MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

// 每日温度. 下一个更高温度出现在几天后, 没有则 0
public class DailyTemperatures {

    // 这里单调栈放索引而不是放元素.
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        // 放索引, 而非元素
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}
