package Nums.Matrix;

// 搜索二维矩阵. 二维矩阵, 每行从左到右升序, 每列从上到下升序
public class SearchMatrix {

    // 对列二分, 再对行二分 —— 逻辑错误啦！！！, 每行升序, 每列升序, 整体逐行或者逐列遍历不一定是升序滴
    public boolean searchMatrixFalse(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int[] col = new int[m];
        for (int i = 0; i < m; i++) {
            col[i] = matrix[i][0];
        }
        int rowNum = getRow(col, target);
        if (rowNum == - 1) {
            return false;
        }
        return isExits(matrix[rowNum], target);
    }

    // 小于 target 的最大索引, 右边界逻辑
    private int getRow(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 收缩左侧区间
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0) {
            return -1;
        }
        return right;
    }

    private boolean isExits(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return false;
    }

    // Z字形查找. 以 matrix 的左下角为左下角、以 (x,y) 为右上角的矩阵中进行搜索，即行的范围为 [x,m−1]，列的范围为 [0,y]：
    // 如果 matrix[x,y] = target, 搜索完成;
    // 如果 matrix[x,y] > target, 由于每一列的元素都是升序排列的, 那么在当前的搜索矩阵中, 所有位于第 y 列的元素都是严格大于 target 的, 将它们全部忽略，即 y--;
    // 如果 matrix[x,y] < target, 由于每一行的元素都是升序排列的, 那么在当前的搜索矩阵中, 所有位于第 x 行的元素都是严格小于 target 的, 将它们全部忽略，即 x++.
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            }
        }
        return false;
    }
}
