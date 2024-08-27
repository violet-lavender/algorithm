package DFS_Backtrack.Backtrack;

import java.util.LinkedList;
import java.util.List;

// 分割回文串
public class PartitionPalindrome {

    List<List<String>> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    // 对于 s, 如果 s[0..i]是回文串, 则将 s 分割为 s[0..i] 和 s[i + 1..], 再对 s[i + 1..] 进行
    private void backtrack(String s, int start) {
        // 注意 start == s.length - 1 是合法的
        if (start == s.length()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            track.add(s.substring(start, i + 1));
            backtrack(s, i + 1);
            track.removeLast();
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
