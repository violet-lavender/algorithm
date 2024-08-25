package TreeNode.BinaryTree;

import TreeNode.TreeNode;

public class MaxDepth {

    // 分解思想. 整棵树的最大深度等于左右子树的最大深度加上根节点自己
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

    // 遍历思想
    int res = 0;
    int depth = 0;
    public int maxDepth0(TreeNode root) {
        traverse(root);
        return res;
    }

    // 进入一个节点后(前序), depth++; 离开一个节点后(后序), depth--; res的更新放在两个之间即可
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点, 更新最大深度
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
