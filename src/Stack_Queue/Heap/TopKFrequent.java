package Stack_Queue.Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

// 前 K 个高频元素
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 最小堆, 保存频率最大的 k 个元素, 注意这里是频率的堆序, 而保存的是元素
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.remove();
        }
        return res;
    }
}