package TreeNode.BST;

import TreeNode.TreeNode;

// 删除二叉搜索树中的节点. 与插入一致, 都是先找再改
public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            // 叶子节点直接删, 赋空即可
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {  // 只有一个非空子节点, 让这个子节点接替自己
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {    // 有两个子节点, 则要找左子树中最大的那个节点, 或者找右子树中最小的那个节点来代替自己
                // 有完整的左右子树, 节点的代替逻辑一定要清晰 —— val 关系和指针关系
                TreeNode minNode = getMinNode(root.right);
                root.val = minNode.val;
                // 删除右子树的最小节点, minNode 的 left 一定为空, 删除比较简单
                root.right = deleteNode(root.right, minNode.val);
                minNode.left = root.left;
                minNode.right = root.right;
                root = minNode;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode getMinNode(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null)
            node = node.left;
        return node;
    }
}
