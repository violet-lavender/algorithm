package Nums.Matrix;

import java.util.ArrayList;
import java.util.List;

// 螺旋矩阵
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        // 边界
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        // 用 size 控制循环比较合适, 不用边界控制循环
        while (res.size() < m * n) {
            // 右、下、左、上 顺序遍历, 外层 if 控制边界
            if (top <= bottom) {
                for (int j = left; j <= right; j++) {
                    res.add(matrix[top][j]);
                }
                top++;
            }
            if (left <= right) {
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;
        while (num <= n * n) {
            // 同样右、下、左、上, 逆向赋值即可
            if (top <= bottom) {
                for (int j = left; j <= right; j++) {
                    matrix[top][j] = num++;
                }
                top++;
            }
            if (left <= right) {
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = num++;
                }
                right--;
            }
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }
}
