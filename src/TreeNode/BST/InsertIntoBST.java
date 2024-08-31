package TreeNode.BST;

import TreeNode.TreeNode;

// 二叉搜索树中的插入操作. 二叉搜索树的插入, 总是存在一个不需调整树结构, 就能插入新节点的方法
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 原节点正常连接, 插入节点在空节点插入, 不破坏原有节点
        if (root == null)
            return new TreeNode(val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        return root;
    }
}
