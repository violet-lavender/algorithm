package Test.T_9_6_FanRuan;

public class T1 {

    // 最长回文字序列
    public int longestPalindromeSubseq (String s) {
        int n = s.length();
        // dp[i][j], 即在子串 s[i...j] 中的最长回文字子序列
        int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 不能同时出现, 分别加入取大者即可
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j - 1], dp[i + 1][j - 1]));
                }
            }
        }
        return dp[0][n - 1];
    }
}
