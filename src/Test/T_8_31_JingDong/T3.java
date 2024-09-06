package Test.T_8_31_JingDong;

import java.util.Scanner;

public class T3 {

    // DP
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[2][n];
        for (int i = 0; i < 2; i++) {
            String[] line = in.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        // dp, dp[i][j] 即从 (i, j) 到 (1, n - 1) 的最优策略
        int[][] dp = new int[2][n];
        // base case
        dp[1][n - 1] = matrix[1][n - 1];
        dp[0][n - 1] = matrix[0][n - 1] + dp[1][n - 1];
        // 辅助数组
        int[][] r = new int[2][n];
        // 右往左逐列推导, 不会出现重复计算
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < 2; i++) {
                r[i][j] = dp[i][j + 1] + matrix[i][j];
            }
            for (int i = 0; i < 2; i++) {
                if ((i + j) % 2 != 0) {
                    // dp[i][j + 1] 表示继续向右走的路径值. r[i ^ 1][j] 表示从另一行(即向上下移动)的路径值。
                    dp[i][j] = Math.max(dp[i][j + 1], r[i ^ 1][j]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j + 1], r[i ^ 1][j]) + matrix[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
        in.close();
    }
}
