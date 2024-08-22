package Nums.Matrix;

// 旋转图像 —— 顺时针90度
public class Rotate {

    // 先正对作角镜像对称, 再作列对称
    public void rotate(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
}
