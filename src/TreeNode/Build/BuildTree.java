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

    public TreeNode constructFromPreIn(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // 通过边界控制得到子树的前序中序数组, 由此不断递归构造
    private TreeNode build1(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int index = valToIndex.get(rootVal);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build1(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build1(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

    // 从中序与后序遍历序列构造二叉树.
    // 后序先是左子树元素, 然后是右子树元素, 最后一个节点是根节点;
    public TreeNode constructFromInPost(int[] inorder, int[] postorder) {
        valToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            valToIndex.put(inorder[i], i);
        return build2(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build2(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;
        int rootVal = postorder[postEnd];
        int index = valToIndex.get(rootVal);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build2(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build2(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    // 根据前序和后序遍历构造二叉树
    // 前序和后序只能确定根节点, 无法确定左右子树, 无法构造唯一确定的二叉树的;
    // 把前序遍历中第二个元素作为左子树根节点的值(事实上左子树可能是空指针,因此还原不唯一), 它在后序序列中是左子树中最后遍历的, 即右边界
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        valToIndex = new HashMap<>();
        for (int i = 0; i < postorder.length; i++)
            valToIndex.put(postorder[i], i);
        return build3(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build3(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd)
            return null;
        // 把前序遍历中第二个元素作为左子树根节点的值, 因此序列中只有一个值时要直接返回, 由于 preStart+1, 防止越界, 这是一个base case
        if (preStart == preEnd)
            return new TreeNode(preorder[preStart]);
        int rootVal = preorder[preStart];
        int leftVal = preorder[preStart + 1];
        int leftIndex = valToIndex.get(leftVal);
        int leftSize = leftIndex - postStart + 1;
        TreeNode root = new TreeNode(rootVal);
        root.left = build3(preorder, preStart + 1, preStart + leftSize, postorder, postStart, leftIndex);
        root.right = build3(preorder, preStart + leftSize + 1, preEnd, postorder, leftIndex + 1, postEnd - 1);
        return root;
    }
}
