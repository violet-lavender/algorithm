package TreeNode.Build;

import TreeNode.TreeNode;

// 最大二叉树.
// 创建一个根节点, 其值为 nums 中的最大值;
// 递归地在最大值左边的子数组前缀上构建左子树;
// 递归地在最大值右边的子数组后缀上构建右子树.
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        // base case, [start, end), 至少要有一个元素, 即 Max(start) = end - 1
        if (start > end - 1)
            return null;
        int index = start;
        for (int i = index + 1; i < end; i++) {
            if (nums[i] > nums[index])
                index = i;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums, start, index);
        root.right = buildTree(nums, index + 1, end);
        return root;
    }
}
