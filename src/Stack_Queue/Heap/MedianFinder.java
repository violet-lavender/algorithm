package Stack_Queue.Heap;

import java.util.PriorityQueue;

// 数据流的中位数.
/* 两个优先级队列 queMax(小顶堆) 和 queMin(大顶堆) 分别记录大于中位数的数和小于等于中位数的数.
当累计添加的数的数量为奇数时, queMin 中的数比 queMax 多一个, 此时中位数为 queMin 的队头;
当累计添加的数的数量为偶数时, 两个优先队列中的数的数量相同, 此时中位数为它们的队头的平均值. */
/* 当尝试添加一个数 num :
注意 queMin.size 总是等于 queMax.size 或者 queMax.size + 1, 通过这判断中位数是否改变, 即是否需要移动.
1. num ≤ max{queMin}: 此时 num 小于等于中位数, 需要将该数添加到 queMin 中.
    新的中位数将小于等于原来的中位数, 因此可能需要将 queMin 中最大的数移动到 queMax 中;
2. num > max{queMin}: 此时 num 大于中位数, 需要将该数添加到 queMax中.
    新的中位数将大于等于原来的中位数, 因此可能需要将 queMax 中最小的数移动到 queMin 中.
3. 特别地, 当累计添加的数的数量为 0 时, 将 num 添加到 queMin 中. */
public class MedianFinder {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queMax = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMin.size() > queMax.size() + 1) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMin.size() < queMax.size()) {
                queMin.offer(queMax.poll());
            }
        }

    }

    public double findMedian() {
        return queMin.size() == queMax.size() + 1 ? queMin.peek() : (queMin.peek() + queMax.peek()) / 2.0;
    }
}