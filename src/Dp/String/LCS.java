package Dp.String;

import java.util.Arrays;

// 最长公共子序列. LCS
public class LCS {

    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(text1, 0, text2, 0);
    }

    // dp: 计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
    private int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 必然在 lcs 中
            memo[i][j] = dp(s1, i + 1, s2, j + 1) + 1;
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中
            memo[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }

    // 两个字符串的删除操作. 使得 s1 和 s2 相同所需的最小步数, 删除的结果即为 LCS
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int lcs = longestCommonSubsequence(word1, word2);
        return m - lcs + n - lcs;
    }
}
