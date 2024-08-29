package Stack_Queue.MonotonicStack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

// 下一个更大的元素, nums1 中的元素在 nums2 中的下一个更大元素(nums1 为 nums2 的子集).
public class NextGreaterElement {

    // 做一个映射查询即可.
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = calculateGreaterElement(nums2);
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    private int[] calculateGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
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
