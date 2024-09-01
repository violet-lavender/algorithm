package Dp.String;

import java.util.*;

// 单词拆分.
// backtrack 超时, dp 更合适.
public class WordBreak {

    HashSet<String> wordsDict;
    int[] memo;    // -1 表示未计算、 0表示无法凑出、 1表示可以凑出

    public boolean wordBreak(String s, List<String> wordDict) {
        wordsDict = new HashSet<>(wordDict);
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0);
    }

    // dp 定义: s[i, …] 是否能被拼出. 对于 s, 如果能从 wordDict 找到前缀s[0, k], 那么只要拼出 s[k + 1…], 就一定能拼出 s
    private boolean dp(String s, int i) {
        // base case: s[i,…]是空串
        if (i == s.length())
            return true;
        if (memo[i] != -1)
            return memo[i] == 1;
        for (int len = 1; i + len <= s.length(); len++) {
            if (wordsDict.contains(s.substring(i, i + len))) {
                boolean subProblem = dp(s, i + len);
                if (subProblem) {
                    memo[i] = 1;
                    return true;
                }
            }
        }
        memo[i] = 0;
        return false;
    }

    // 返回拆分方法. 回溯、 dp 都可以, 这个回溯不会超时
    List<String> res = new LinkedList<>();
    List<String> wordDict;
    LinkedList<String> track = new LinkedList<>();

    public List<String> wordBreak1(String s, List<String> wordDict) {
        this.wordDict = new ArrayList<>(wordDict);
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int i) {
        if (i == s.length()) {
            res.add(String.join(" ", track));
            return;
        }
        for (String word : wordDict) {
            int len = word.length();
            if (i + len <= s.length() && s.substring(i, i + len).equals(word)) {
                track.addLast(word);
                backtrack(s, i + len);
                track.removeLast();
            }
        }
    }
}
