package TreeNode.Ancestor;

import TreeNode.TreeNode;

import java.util.HashSet;

// LAC问题, 二叉树的最近公共祖先
public class LCA {

    // 两个节点的 LCA, 二叉树不含重复值, 且两个节点一定存在于二叉树中
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    // 查找目标节点. 充分利用前序和后序的性质.
    private TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        // 前序位置, 遇到目标节点则直接返回. (放在后序也可以, 放在前序可以提前终止搜索, 减少不必要的遍历)
        if (root.val == val1 || root.val == val2) {
            return root;
        }
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);
        // 后序位置, 已经知道左右子树是否存在目标值 —— 如果两边都找到了目标节点, 说明当前节点是 LCA 节点
        if (left != null && right != null) {
            return root;
        }
        // 如果只有一边找到目标节点(两个目标节点位于同一侧子树), 则返回找到的那一边的节点(非空的子树)
        return left != null ? left : right;
    }

    // 一组节点的 LCA, 二叉树不含重复值且节点一定存在
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }
        return find(root, values);
    }

    private TreeNode find(TreeNode root, HashSet<Integer> values) {
        if (root == null) {
            return null;
        }
        // 前序位置, 遇到目标节点则直接返回
        if (values.contains(root.val)) {
            return root;
        }
        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);
        // 后序位置, 已经知道左右子树是否存在目标值
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    // 两个节点的 LCA, 二叉树不含重复值, 但两个节点不一定存在于二叉树中
    boolean foundP = false, foundQ = false;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = find2(root, p.val, q.val);
        if (!foundP || !foundQ) {
            return null;
        }
        return res;
    }

    // 此时不能遇到目标值就直接返回, 而应该对二叉树进行完全搜索, 目标节点的查找就必须放在后序.
    private TreeNode find2(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        TreeNode left = find2(root.left, val1, val2);
        TreeNode right = find2(root.right, val1, val2);
        // 后序位置, 判断当前节点是不是 LCA 节点
        if (left != null && right != null) {
            return root;
        }
        // 后序位置, 判断当前节点是否为目标节点
        if (root.val == val1 || root.val == val2) {
            if (root.val == val1) {
                foundP = true;
            }
            if (root.val == val2) {
                foundQ = true;
            }
            return root;
        }
        return left != null ? left : right;
    }
}
