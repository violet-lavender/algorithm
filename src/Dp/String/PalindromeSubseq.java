package Dp.String;

// 子序列问题, 关于 dp 的定义
// 一维的 dp 数组, 如最长递增子序列、最大子数组和等, 在子数组中 arr[0..i] 中, 以 arr[i] 结尾的子序列长度是 dp[i]
// 二维的 dp 数组, 涉及到两个字符串/数组的场景, 在子数组 arr[0..i] 和子数组 arr[0..j] 中, 要求子序列长度为 dp[i][j]
//               只涉及到一个字符串/数组的场景, 在子数组 arr[i..j] 中, 要求子序列的长度为 dp [i][j]

// 最长回文子序列. dp: 在字串 s[i..j]中, 最长回文子序列的长度为 dp[i][j]
// s[i] == s[j], 则 dpi][j] = dp[i + 1][j - 1] + 2,
// 若不相等, 则它们不能同时出现在 s[i..j] 的最长回文子序列中, 把它们分别加入 s[i + 1, j - 1] 中, 比较哪个字串产生的回文子序列更长即可
// 即 dpi][j] = max (dp[i + 1][j], dp[i][j - 1]),
//                  那么 dp[i][j] 需要知道 dp[i + 1][j], dp[i][j - 1], dp[i + 1][j - 1], 斜着遍历或反着遍历
public class PalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 反着遍历保证正确的状态转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    // 让字符串成为回文串的最少插入次数. 找到最长回文子序列, 不在最长回文子序列的字符, 直接插入即可
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}
