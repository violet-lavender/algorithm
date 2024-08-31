package TreeNode.BinaryTree;

import TreeNode.TreeNode;

// 完全二叉树的节点个数.
// 完全二叉树: 每一层都是紧凑靠左排列的; 满二叉树: 每层都是满的.
public class CountNodes {

    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 左右侧高度相同则是满二叉树, 按照满二叉树逻辑计算
        if (hl == hr)
            return (int) Math.pow(2, hl) - 1;
        // 否则按照普通二叉树的逻辑计算, 一个完全二叉树的两棵子树, 至少有一棵是满二叉树, 降低时间复杂度
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 普通二叉树计算节点数的标准遍历方法, O(N)的复杂度
    public int countTreeNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countTreeNodes(root.left) + countTreeNodes(root.right);
    }
}
