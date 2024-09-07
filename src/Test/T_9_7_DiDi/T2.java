package Test.T_9_7_DiDi;

import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);
        int[][] matrix = new int[k][k];
        int i = 0;
        while (i < k) {
            String[] line = in.nextLine().split(" ");
            for (int j = 0; j < k; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
            i++;
        }
        String s = in.nextLine();
        char[] sc = s.toCharArray();
        // dp[i][j] 表示从字符串第 i 个字符到第 j 个字符之间的最大消除代价.
        long[][] dp = new long[n][n];
        for (i = 0; i < n - 1; i++) {
            dp[i][i + 1] = matrix[sc[i] - 'a'][sc[i + 1] - 'a'];
        }
        // 枚举区间长度
        for (int len = 3; len <= n; len++) {
            // i 表示区间左端点, j 表示区间右端点, 对于每一个 len, 都计算 dp[i][j]
            for (i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // 子串长度为奇数, 不能直接消除该子串的第一个和最后一个字符, 因为中间有一个字符无法配对消除
                if (len % 2 == 1) {
                    // 考虑边界方案, 考虑移除 j 位置后的最大代价和移除 i 位置后的最大代价, 取大者
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    // 尝试在区间 [i, j] 中分割出子串, 取大者
                    for (int t = i + 1; t < j; t++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][t - 1] + dp[t + 1][j]);
                    }
                } else {    // 子串长度为偶数, 可以直接消除该子串的第一个和最后一个字符, 并加上剩余部分 [i+1, j-1] 的最大代价
                    dp[i][j] = dp[i + 1][j - 1] + matrix[sc[i] - 'a'][sc[j] - 'a'];
                    // 同时也可以尝试分割子串, 取大者
                    for (int t = i; t < j; t++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][t] + dp[t + 1][j]);
                    }
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
