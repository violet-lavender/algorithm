package TreeNode.BST;

import TreeNode.TreeNode;

// 二叉搜索树中的搜索, 充分利用搜索二叉树特性即可
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val > val)
            return searchBST(root.left, val);
        if (root.val < val)
            return searchBST(root.right, val);
        return root;
    }
}
