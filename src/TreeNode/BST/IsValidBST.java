package TreeNode.BST;

import TreeNode.TreeNode;

// 验证二叉搜索树
public class IsValidBST {

    // 错误逻辑!!! 对于每一个节点, 代码只检查了它的左右孩子节点是否符合左小右大, 但实际上应该是整个左右子树
    public boolean isValidBSTFalse(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBSTFalse(root.left) && isValidBSTFalse(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root, null, null);
    }

    // 该函数返回 root 为根的子树的所有节点是否满足 max.val > root.val > min.val. 参数携带信息并向下传递, 实现约束
    // 这里参数可以用 Long, 初始传参 MIN、MAX, 注意不能用 Integer, 有几个用例很难绷
    private boolean _isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 限定左子树的最大值(右子树的最小值)为 root.val, 同时在参数中携带信息, 将约束传递给子树中所有节点
        return _isValidBST(root.left, min, root) && _isValidBST(root.right, root, max);
    }
}
