package Graph.DFS;

//岛屿问题
public class IsLands {

    // 岛屿数量. 0 表示海水, 1 表示陆地, 且矩阵四周都是被海水包围的. 成片的陆地被称为岛屿.
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿, 计数 + 1, 并把岛屿淹没
                    res++;
                    dfs1(grid, i, j);
                }
            }
        }
        return res;
    }

    // 淹没岛屿, 从(i,j)开始, 将与之相邻的陆地淹没(变为海水)
    private void dfs1(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs1(grid, i - 1, j);
        dfs1(grid, i + 1, j);
        dfs1(grid, i, j - 1);
        dfs1(grid, i, j + 1);
    }

    // 封闭岛屿的数量. 0 表示陆地, 1 表示海水, "封闭岛屿", 即上下左右都被 1 包围的 0, 显然靠边的陆地不是封闭岛屿.
    // 与岛屿数量基本一致, 排除靠边岛屿即可.
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            // 淹没左右两边岛屿
            dfs2(grid, i, 0);
            dfs2(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            // 淹没上下两侧岛屿
            dfs2(grid, 0, j);
            dfs2(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs2(grid, i, j);
                }
            }
        }
        return res;
    }

    // 淹没岛屿
    private void dfs2(int[][] grip, int i, int j) {
        if (i < 0 || i >= grip.length || j < 0 || j >= grip[0].length)
            return;
        if (grip[i][j] == 1)
            return;
        grip[i][j] = 1;
        dfs2(grip, i - 1, j);
        dfs2(grip, i + 1, j);
        dfs2(grip, i, j - 1);
        dfs2(grip, i, j + 1);
    }

    // 飞地的数量. 不靠边界的陆地数量, 靠边的淹没, 然后直接计数即可
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            //淹没左右两边岛屿
            dfs3(grid, i, 0);
            dfs3(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            //淹没上下两侧岛屿
            dfs3(grid, 0, j);
            dfs3(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs3(int[][] grip, int i, int j) {
        if (i < 0 || i >= grip.length || j < 0 || j >= grip[0].length)
            return;
        if (grip[i][j] == 0)
            return;
        grip[i][j] = 0;
        dfs3(grip, i - 1, j);
        dfs3(grip, i + 1, j);
        dfs3(grip, i, j - 1);
        dfs3(grip, i, j + 1);
    }

    // 岛屿最大面积, 用 dfs 返回值记录每次淹没的陆地的个数
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    res = Math.max(res, dfs4(grid, i, j));
            }
        }
        return res;
    }

    // 淹没与(i,j)相邻的陆地, 并返回淹没的陆地面积
    private int dfs4(int[][] grip, int i, int j) {
        if (i < 0 || i >= grip.length || j < 0 || j >= grip[0].length)
            return 0;
        if (grip[i][j] == 0)
            return 0;
        grip[i][j] = 0;
        // 记得 +1 加上本身
        return dfs4(grip, i - 1, j) + dfs4(grip, i + 1, j) + dfs4(grip, i, j - 1) + dfs4(grip, i, j + 1) + 1;
    }

    // 统计子岛屿
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // B 中存在一片陆地, 而在 A 中对应位置为海水, 那么岛屿 B 就不是岛屿子岛, 将其淹没
                if (grid1[i][j] == 0 && grid2[i][j] == 1)
                    dfs3(grid2, i, j);
            }
        }
        // 现在 grid2 中剩下的都是子岛,计算岛屿数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs3(grid2, i, j);
                }
            }
        }
        return res;
    }
}
