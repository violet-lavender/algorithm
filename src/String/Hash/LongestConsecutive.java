package String.Hash;

import java.util.*;

// 最长连续序列. 要求时间复杂度为O(n), 空间换时间, 用哈希
// 想找连续序列, 首先要找到这个连续序列的开头元素, 然后递增, 看之后有多少个元素还在 nums 中，即可得到最长连续序列的长度
// 找开头元素时是分精妙且关键的操作
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int res = 0;
        for (int num : set) {
            // 不是连续子序列的开头元素, 则跳过
            if (set.contains(num - 1))
                continue;
            // 是连续子序列的开头元素, 开始向上计算连续子序列的长度
            int curNum = num;
            int curLen = 1;
            while (set.contains(curNum + 1)) {
                curNum++;
                curLen++;
            }
            res = Math.max(res, curLen);
        }
        return res;
    }
}
