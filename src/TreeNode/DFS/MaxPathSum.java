package TreeNode.DFS;

import TreeNode.TreeNode;

// 最大路径和
public class MaxPathSum {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        oneSideMax(root);
        return res;
    }

    // 计算从根节点 root 为起点的最大单边路径和
    private int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxSum = Math.max(0, oneSideMax(root.left));
        int rightMaxSum = Math.max(0, oneSideMax(root.right));
        // 后序位置, 更新最大路径和
        int pathMaxSum = root.val + leftMaxSum + rightMaxSum;
        res = Math.max(res, pathMaxSum);
        // 左右子树的最大单边路径加上根节点的值, 就是从根节点 root 为起点的最大单边路径和
        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }
}
