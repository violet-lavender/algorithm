package String.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 找到字符串中所有字母异位词
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);
        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 窗口内数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            // 窗口收缩
            while (right - left >= p.length()) {
                if (valid == need.size())
                    res.add(left);
                char d = s.charAt(left);
                left++;
                // 窗口内数据更新, 与扩大窗口时的更新是对称操作
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }
}
