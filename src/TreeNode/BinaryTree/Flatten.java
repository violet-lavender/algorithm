package TreeNode.BinaryTree;

import TreeNode.TreeNode;

// 二叉树展开为链表
public class Flatten {

    // 分解. 递归的继续如下操作: 将右子树接到左子树下方, 然后将整个左子树作为右子树(注意连接时的方向控制逻辑). 需要左右子树信息, 显然是后序.
    // (反过来也可以: 将左子树作为右子树, 然后将原本的右子树接到当前右子树的末端(这样连接逻辑相对简单))
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 将左子树作为右子树
        root.left = null;
        root.right = left;
        // 将原本的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
