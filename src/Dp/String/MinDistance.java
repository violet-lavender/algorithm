package Dp.String;

import java.util.Arrays;

// 编辑距离. 将 word1 装换成 word2 所使用的最少操作数
public class MinDistance {

    int[][] memo;

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        // 两个字符串的 DP 问题, 一般都是用两个指针分别指向两个字符串的最后, 然后一步步向前移动, 缩小问题规模
        return dp(word1, m - 1, word2, n - 1);
    }

    public int dp(String s1, int i, String s2, int j) {
        // 当 i 走完 s1 时, 插入即可
        if (i == -1)
            return j + 1;
        // 当 j 走完 s2 时, 删除即可
        if (j == -1)
            return i + 1;
        if (memo[i][j] != -1)
            return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            // 如果两个字符相同, 则不需要操作, 直接跳过
            memo[i][j] = dp(s1, i - 1, s2, j - 1);
        } else {
            // 如果两个字符不同, 则需要进行三种操作: 插入, 删除, 替换
            // dp(s1, i, s2, j - 1) + 1 —— 插入, 在 s1[i] 插入 s2[j], 则 s2[j] 就被匹配了, j 前移, 同时操作数 + 1
            // dp(s1, i - 1, s2, j) + 1 —— 删除, 直接删除 s1[i], i 前移, 同时操作数 + 1
            // dp(s1, i - 1, s2, j - 1) + 1 —— 替换, 把 s1[i] 替换 s2[j], 于是它俩就匹配了, i, j 前移, 同时操作数 + 1
            memo[i][j] = Math.min(dp(s1, i - 1, s2, j) + 1,
                    Math.min(dp(s1, i, s2, j - 1) + 1, dp(s1, i - 1, s2, j - 1) + 1));
        }
        return memo[i][j];
    }
}
