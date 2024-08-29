package Stack_Queue.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// 优势洗牌 —— 类田忌赛马 "返回 nums1 的任意排列, 使其相对于 nums2 的优势最大化"
// 排序, 按排名一一对比, 前者大则直接比, 前者小则换最小的来送掉
public class AdvantageCount {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 结果依赖于 nums2 的顺序, 所以不能对 nums2 直接排序;
        // 需要 nums2 的大小信息(排序), 同时又需要其索引信息, 用降序的优先级队列最为合适
        PriorityQueue<int[]> maxNums2 = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < nums2.length; i++)
            maxNums2.add(new int[]{i, nums2[i]});
        Arrays.sort(nums1);
        int n = nums1.length;
        int left = 0, right = n - 1;
        int[] res = new int[n];
        while (!maxNums2.isEmpty()) {
            int[] pair = maxNums2.poll();
            int index = pair[0], val = pair[1];
            if (val < nums1[right]) {
                // 能赢则直接上
                res[index] = nums1[right];
                right--;
            } else {
                // 不能赢就送掉
                res[index] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
