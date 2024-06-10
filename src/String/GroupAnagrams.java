package String;

import java.util.*;

// 字母异位词分组
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //  String s = strSort(str);
            String s = strCount(str);
            if (map.containsKey(s))
                map.get(s).add(str);
            else {
                // 当新的键值对被添加时, 需要创建一个包含当前字符串的新列表, 而不是空列表
                // List.of() 返回的列表是不可变的, 不能向其添加元素
                // 因此 map.put(s, List.of(str));会报错
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(s, newList);
            }
        }
        return new ArrayList<>(map.values());
    }

    // 字符排序后作key
    public String strSort(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

    // 字符与其出现次数作key,少了排序,时间复杂度更低
    public String strCount(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++)
            counts[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                sb.append((char) (i + 'a'));
                sb.append(counts[i]);
            }
        }
        return sb.toString();
    }
}
