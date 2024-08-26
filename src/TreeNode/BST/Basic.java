package TreeNode.BST;

import TreeNode.TreeNode;

// 二叉搜索树(BST).
/* 对于 BST 的每一个节点 node, 左子树节点的值都比 node 的值小, 右子树节点的值都比 node 的值大;
对于 BST 的每一个节点 node, 它的左侧子树和右侧子树都是 BST. */
// BST 的中序遍历结果是升序的.
public class Basic {

    // BST 问题框架
    public void BST(TreeNode root, int target) {
        if (root.val == target) {

        }
        if (root.val < target) {
            BST(root.right, target);
        }
        if (root.val > target) {
            BST(root.left, target);
        }
    }
}
