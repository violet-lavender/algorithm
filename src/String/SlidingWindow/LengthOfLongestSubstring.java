package String.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// 无重复字符的最长子串
public class  LengthOfLongestSubstring {

    // 滑动窗口经典解法, 窗口存储字符及其出现次数
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            // 窗口中有重复字符时收缩窗口,至没有重复字符
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    // 窗口优化, 窗口存储字符及其索引
    public int lengthOfLongestSubstringPro(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 出现重复时 left 直接跳跃到重复处, 注意重复点一定要在窗口内
            if (window.containsKey(c) && left < window.get(c)) {
                left = window.get(c);
            }
            window.put(c, right);
            res = Math.max(res, right - left);
        }
        return res;
    }
}
