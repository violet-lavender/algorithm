package TreeNode.Build;

import TreeNode.TreeNode;

// 将有序数组转换为平衡二叉搜索树
public class SortedArrayToBST {

    // 二叉树的构造: 构造根节点, 递归的构造左右子树
    // 一个有序数组对于 BST 来说就是中序遍历的结果, 根节点在数组中心、 左侧是左子树元素、 右侧是右子树元素
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
