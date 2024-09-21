package TreeNode.Trie;

import java.util.ArrayList;
import java.util.List;

// [1, n] 字典序排数
// 对于 num, 如果 num * 10 <= n, 那么 num * 10 是下一个字典序整数;
// 否则, 就在当层继续寻找, 如果 num % 10 == 9 或者 num + 1 > n, 则当层寻找完毕, 回退到上一层.
public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            res.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return res;
    }
}
