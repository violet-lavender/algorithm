package Stack_Queue.MonotonicQueue;

import java.util.LinkedList;

// 单调队列
public class MonotonicQueue {
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
