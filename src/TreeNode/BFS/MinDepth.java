package TreeNode.BFS;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 二叉树的最小深度
public class MinDepth {

    // BFS 最先找出来的一定是最小深度
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 判断是否到达终点(叶子节点)
                if (cur.left == null && cur.right == null)
                    return depth;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            depth++;  // 遍历完一层增加步数
        }
        return depth;
    }
}
