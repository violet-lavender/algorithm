package TreeNode.BST;

import TreeNode.TreeNode;

// 把二叉搜索树转换为累加树 —— 每个节点 node 的新值等于原树中大于或等于 node.val 的值之和.
public class ConvertBST {

    public TreeNode convertBST(TreeNode root) {
        inTraverse(root);
        return root;
    }
    // 反序中序遍历(右中左), 得到降序序列, 维护一个累加变量 sum, 完成转换
    int sum = 0;
    public void inTraverse(TreeNode root){
        if(root == null)
            return;
        inTraverse(root.right);
        sum += root.val;
        root.val = sum;
        inTraverse(root.left);
    }
}
