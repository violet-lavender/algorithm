package String.Hash;

import java.util.HashMap;

// 赎金信. 前者能不能由后者中的字符构成
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : magazine.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (Character c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) != 0)
                map.put(c, map.get(c) - 1);
            else
                return false;
        }
        return true;
    }

    // 巧妙利用 char 和 int, 根据 char - 'a', 完成字符(值)与数字(索引)的转换
    public boolean canConstructPro(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        int[] cnt = new int[26];
        for (Character c : magazine.toCharArray())
            cnt[c - 'a']++;
        for (Character c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}
