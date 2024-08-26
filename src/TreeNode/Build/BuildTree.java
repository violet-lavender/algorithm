package TreeNode.Build;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 二叉树的构造: 构造根节点, 递归的构造左右子树
public class BuildTree {

    // 从前序与中序遍历序列构造二叉树
    // 前序第一个为根节点, 然后是左子树元素, 最后是右子树元素;
    // 找到中序根节点, 其左侧是左子树元素、 右侧是右子树元素, 由此递归构造. 注意没有中序无法构造(不唯一)
    Map<Integer, Integer> valToIndex = new HashMap<>();  // 中序数组值到索引的映射

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // 通过边界控制得到子树的前序中序数组, 由此不断递归构造
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int index = valToIndex.get(rootVal);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
