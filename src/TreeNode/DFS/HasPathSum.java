package TreeNode.DFS;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 路径总和.
public class HasPathSum {

    int sum = 0;
    boolean sign = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        hasPath(root, targetSum);
        return sign;
    }

    private void hasPath(TreeNode node, int target) {
        if (node == null)
            return;
        sum += node.val;
        if (sum == target && node.left == null && node.right == null)
            sign = true;
        hasPath(node.left, target);
        hasPath(node.right, target);
        sum -= node.val;
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null)
            return;
        path.addLast(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null)
            res.add(new ArrayList<>(path));
        dfs(node.left, target);
        dfs(node.right, target);
        target += node.val;
        path.removeLast();
    }
}
