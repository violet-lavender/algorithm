package TreeNode.BinaryTree;

import TreeNode.TreeNode;

// 翻转二叉树
public class InvertTree {

    // 遍历. 前序、中序、后序都可(中序略有不同)
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置, 放在后序也可以, 直接放在中序有点问题, 放在中序会使left翻转两次, 而right没有翻转, 所以最后的 traverse(root.right) 需要改为 traverse(root.left)
        traverse(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        traverse(root.left);
    }

    // 分解也可
    public TreeNode invertTreeO(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 先翻转左右子树, 然后交换左右节点完成整棵树的翻转
        TreeNode left = invertTreeO(root.left);
        TreeNode right = invertTreeO(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
