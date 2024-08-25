package TreeNode.BinaryTree;

import TreeNode.TreeNode;

// 二叉树的直径
// 每一条二叉树的直径长度, 就是一个节点的左右子树的最大深度之和
// 前序遍历, 计算每个节点的左右子树的最大深度之和, 再依次递归
// 但是缺点明显, 因为前序位置无法获得子树信息, 遍历时递归, 求最大深度又递归, 时间复杂度很高
// 后序遍历计算深度时顺便计算最大直径
public class Diameter {

    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int curDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter,curDiameter);
        return Math.max(leftMax,rightMax) + 1;
    }
}
