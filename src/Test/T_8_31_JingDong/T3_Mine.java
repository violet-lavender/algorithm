package Test.T_8_31_JingDong;

import java.util.Scanner;

public class T3_Mine {

    // 暴力模拟, 贪心逻辑
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
        boolean[][] visited = new boolean[2][n];
        int k = 0;
        int curX = 0, curY = 0;
        visited[curX][curY] = true;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}};
        int res = 0;
        while (curX != 1 || curY != n - 1) {
            res += matrix[curX][curY];
            if (k % 2 == 0) {
                int tempMin = Integer.MAX_VALUE;
                int tempX = 0, tempY = 0;
                for (int[] dir : dirs) {
                    int newX = curX + dir[0];
                    int newY = curY + dir[1];
                    if (newX >= 0 && newX < 2 && newY < n && !visited[newX][newY] && matrix[newX][newY] < tempMin) {
                        tempMin = matrix[newX][newY];
                        tempX = dir[0];
                        tempY = dir[1];
                    }
                }
                curX += tempX;
                curY += tempY;
                visited[curX][curY] = true;
                k++;
            } else {
                int tempMax = Integer.MIN_VALUE;
                int tempX = 0, tempY = 0;
                for (int[] dir : dirs) {
                    int newX = curX + dir[0];
                    int newY = curY + dir[1];
                    if (newX >= 0 && newX < 2 && newY < n && !visited[newX][newY] && matrix[newX][newY] > tempMax) {
                        tempMax = matrix[newX][newY];
                        tempX = dir[0];
                        tempY = dir[1];
                    }
                }
                curX += tempX;
                curY += tempY;
                visited[curX][curY] = true;
                k++;
            }
        }
        res += matrix[curX][curY];
        System.out.println(res);
        in.close();
    }
}
