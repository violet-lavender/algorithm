package Stack_Queue.MonotonicQueue;

import java.util.LinkedList;

// 单调队列. 单调队列常用于解决滑动窗口最值、动态区间查询的问题
/* 单调递增队列: 队内元素按从队头到队尾递增排序, 即队尾元素总是大于等于队头元素,
当遇到一个比队尾元素小的元素时, 将队尾元素移除, 直到队尾元素小于等于当前元素或者队列为空 */

// 单调栈能够获取局部相邻元素信息, 适合处理"最近一次"、"下一个"、"前一个"等相关问题,
// 而单调队列能够在一定范围内获取全局最值信息, 适合处理滑动窗口最值、动态区间查询问题

/* 数据结构(栈和队列)单调性与求解问题的特性相反, 下一个更大元素需要用单调递减栈, 滑动窗口最大值需要单调递减队列.
单调递减栈: 通过递减性, 帮助找到右侧的"下一个更大元素";
单调递减队列: 通过递减性, 始终保持队头是当前范围内的最大值. */

/* 严格性问题: 是否严格单调还是要看具体问题.
如, 下一个更大元素需要严格单调, 而滑动窗口最大值不需要严格单调. */
public class MonotonicQueue {
    // 这是个单调递减队列
    LinkedList<Integer> maxQueue = new LinkedList<>();

    // 注意入队时, 要把比 num 小的元素推掉, 保持"单调"
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
