package DFS_Backtrack.DFS;

// 单词搜索
public class WordExist {

    boolean[][] visited;
    boolean res = false;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, word, i, j, 0);
                if (res) {
                    break;
                }
            }
        }
        return res;
    }

    // 这是个典型的 dfs 而非 backtrack, 标记的撤销时因为需要多次遍历(最经典的 dfs 是一次性遍历, 不需要撤销), 认为这是"清除现场"而非"撤销选择"
    private void dfs(char[][] board, String s, int i, int j, int k) {
        if (board[i][j] != s.charAt(k)) {
            return;
        } else if (k == s.length() - 1) {
            res = true;
            return;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
                continue;
            }
            dfs(board, s, x, y, k + 1);
        }
        visited[i][j] = false;
    }
}
