package BFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 单词接龙. 序列转换问题.
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord))
            return 0;
        Set<String> q1 = new HashSet<>();
        q1.add(beginWord);
        Set<String> q2 = new HashSet<>();
        q2.add(endWord);
        Set<String> visited = new HashSet<>();
        int step = 1;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            Set<String> temp = new HashSet<>();
            for (String cur : q1) {
                if (q2.contains(cur))
                    return step;
                for (String next : words) {
                    if (isNext(cur, next) && !visited.contains(next)) {
                        temp.add(next);
                        visited.add(cur);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return 0;
    }

    // 判断是否只差一个字母, 即是否为下一个序列.
    public boolean isNext(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        boolean res = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (res)
                    return false;
                res = true;
            }
        }
        return res;
    }
}
