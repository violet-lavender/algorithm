package BFS;

import java.util.LinkedList;
import java.util.Queue;

// 腐烂的橘子. BFS
public class OrangesRotting {

    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        int flag = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    flag++;
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty() && flag != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        flag--;
                    }
                }
            }
            res++;
        }
        return flag == 0 ? res : -1;
    }
}