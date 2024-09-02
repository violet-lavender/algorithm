package Dp.String;

// 最长有效括号
public class LongestValidParentheses {

    /* dp[i] 表示以 s[i] 结尾的最长有效括号的长度, 显然 s[i] == '(' 时, dp[i] = 0, 考虑 s[i] == ')', 每两个字符检查一次
       s[i] == ')' 且 s[i - 1] == '(', 则 dp[i] = dp[i - 2] + 2;
       s[i] == ')' 且 s[i - 1] == ')', 若 s[i - dp[i - 1] - 1] == '(', 则 dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2 (仔细思考这里的逻辑) */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
