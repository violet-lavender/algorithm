package TreeNode.DFS;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 路径总和. 路径不需要从根节点开始, 也不需要在叶子节点结束, 保证路径方向向下即可.
public class PathSum {

    // DFS
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int res = rootSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    // 以 root 为起点向下且满足路径总和为 val 的路径数目
    // 二叉树中隐式的选择与撤销. 二叉树递归模式固定, 没有复杂的回溯需求(访问路径唯一且无环), 在图论的 DFS 中很少见(需要显式选择与撤销).
    // 每次递归都进行 targetSum - val, 选择; 而递归天然就包含了撤销选择过程, 当递归返回时, 程序回到了上一个节点的状态, 撤销选择.
    // 这里与之前两个路径之和不同, 没有 sum、target 等需要维护的状态信息, 不是传统的dfs, 甚至还有返回值.
    private int rootSum(TreeNode root, long targetSum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            res++;
        }
        res += rootSum(root.left, targetSum - val);
        res += rootSum(root.right, targetSum - val);
        return res;
    }

    // 前缀和. 遍历过程中, 对于当前节点, 计算从根节点到当前节点的前缀和currSum, 如果哈希表中存在 currSum - targetSum, 则找到.
    // 前缀和中 pre[i] = num[0...i], pre[j] = num[0...j], pre[j] - pre[i] = num[i + 1...j]
    public int pathSumPro(TreeNode root, long targetSum) {
        // 前缀和及其出现次数
        Map<Long, Integer> prefixCount = new HashMap<>();
        // 初始情况下, 前缀和为 0 的路径数为 1(对应于根节点的情况)
        prefixCount.put(0L, 1);
        return dfs(root, 0, targetSum, prefixCount);
    }

    // 这严格意义上是一个 backtrack 而不是 dfs
    private int dfs(TreeNode root, long currSum, long targetSum, Map<Long, Integer> prefixCount) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        int res = prefixCount.getOrDefault(currSum - targetSum, 0);
        // 更新前缀和的计数
        prefixCount.put(currSum, prefixCount.getOrDefault(currSum, 0) + 1);
        res += dfs(root.left, currSum, targetSum, prefixCount);
        res += dfs(root.right, currSum, targetSum, prefixCount);
        // 回溯, 撤销当前节点对前缀和的影响, 保证哈希表中只包含与当前路径相关的前缀和信息
        prefixCount.put(currSum, prefixCount.get(currSum) - 1);
        return res;
    }
}
