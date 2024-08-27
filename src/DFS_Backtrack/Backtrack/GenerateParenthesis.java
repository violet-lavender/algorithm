package DFS_Backtrack.Backtrack;

import java.util.ArrayList;
import java.util.List;

// 括号生成
/* 关于括号问题:
一个合法括号组合的左括号数量一定等于右括号数量;
对于一个合法的括号字符串组合 p, 必然有对于任何 0 <= i <= len(p) —— 子串 p[0..i]中左括号数量一定大于或等于右括号数量. */
public class GenerateParenthesis {

    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        backtrack(n, n);
        return res;
    }

    // 可用的左括号数量为 left, 可用的右括号数量为 right
    private void backtrack(int left, int right) {
        // 左括号剩下的更多, 不满足性质2, 不合法
        if (left > right) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        // 此时所有括号都恰好用完且满足所有性质, 得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }
        // 做选择, 尝试放一个左括号
        track.append("(");
        backtrack(left - 1, right);
        // 撤销选择
        track.deleteCharAt(track.length() - 1);
        // 做选择, 尝试放一个右括号
        track.append(")");
        backtrack(left, right - 1);
        // 撤销选择
        track.deleteCharAt(track.length() - 1);
    }
}
