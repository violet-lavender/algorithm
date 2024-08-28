package String.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// 字符串的排列, s2 是否包含 s1 的排列
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int left = 0, right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            // 注意收缩时机, 一旦窗口长度大于要求长度, 则进行判断和收缩.
            while (right - left >= s1.length()) {
                if (valid == need.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
