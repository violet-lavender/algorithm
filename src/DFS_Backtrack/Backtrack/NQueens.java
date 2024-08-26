package DFS_Backtrack.Backtrack;

import java.util.ArrayList;
import java.util.List;

// N皇后问题
public class NQueens {

    // 输入棋盘边长 n, 返回所有合法的位置
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        // 初始化棋盘, 每个字符串代表一行, 字符串列表代表一个棋盘; '.' 表示空, 'Q' 表示皇后
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        backtrack(board, 0);
        return res;
    }

    // 路径: board 中小于 row 的行都已经成功放置了皇后, 尝试在第 row 行放置皇后
    // 选择列表: 第 row 行的所有列都是放置皇后的选择
    // 结束条件: row 超过 board 的最后一行, 则成功放置了 n 个皇后
    private void backtrack(List<String> board, int row) {
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            char[] rowChars = board.get(row).toCharArray();
            rowChars[col] = 'Q';
            board.set(row, new String(rowChars));
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            rowChars[col] = '.';
            board.set(row, new String(rowChars));
        }
    }

    // 逐行摆放, 每行只放一个, 没有行冲突
    // 同时不用关注右下和左下(因为此时下方还没放), 判断左上和右下已经(相对的)判断了右下和左上
    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        // 检查列是否有冲突
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

}
