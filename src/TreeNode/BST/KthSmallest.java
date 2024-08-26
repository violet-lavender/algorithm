package TreeNode.BST;

import TreeNode.TreeNode;

// 二叉搜索树中第 K 小的元素
public class KthSmallest {

    // 注意, 这里 rank 初始化为 1, 在中序时先比较、 然后 rank++ 是不可行的!!!, 递归会出现逻辑错误
    int res = 0;
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
