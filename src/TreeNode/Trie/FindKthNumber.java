package TreeNode.Trie;

// 字典序的第 k 小数字. 前序遍历字典树, 第 k 个节点即为第 k 小数字. 实际不需要遍历, 计算即可.
/* 设当前字典树第 i 小的节点为 ni, 则只需按照先序遍历再继续往后找 k - i 个节点即为目标节点.
设以 ni 为根节点构成的子树的节点数目为 steps(ni), 则有两种可能:
 若 steps(ni) <= k - i, 则第 k 小的节点一定不在 ni 为根的子树中, 此时跳过 steps(ni) 个节点, 从兄弟节点 n(i + 1) 往后查找 k - i - steps(ni) 个节点;
 若 steps(ni) > k - i, 则第 k 小的节点一定在 ni 为根的子树中, 此时跳过 ni, 从 ni 的最左子节点(其值为 10 * ni)开始往后查找 k - i + 1 个节点.
重复操作直到找到第 k 小的节点. */
/* 计算 steps(ni): 层次遍历思想. first[i] 指向 i 层的最左侧节点, last[i] 指向 i 层的最右侧节点.
first[i] = 10 * first[i - 1], last[i] = 10 * last[i - 1] + 9, 第 i 层的节点数目为 last[i] - first[i] + 1.
由于所有的节点都需要小于等于 n, 所以第 i 层的最右侧节点应该为 min(n, last[i]), 不断迭代直到 first[i] > n. */

public class FindKthNumber {

    public int findKthNumber(int n, int k) {
        // 从 1(第一个节点)开始计数, 所以 k--
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(cur, n);
            if (steps <= k) {
                k -= steps;
                cur++;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }

    private int getSteps(int cur, long n) {
        int steps = 0;
        long first = cur;
        long last = cur;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}
