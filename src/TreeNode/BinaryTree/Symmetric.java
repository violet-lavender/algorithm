package TreeNode.BinaryTree;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 对称二叉树
public class Symmetric {

    // 中序遍历, 借助双向链表 —— 错误做法
    LinkedList<Integer> res = new LinkedList<>();
    public boolean isSymmetricFalse(TreeNode root) {
        inorderTraver(root, false);
        while (res.size() > 1) {
            if (!res.removeFirst().equals(res.removeLast())) {
                return false;
            }
        }
        return true;
    }

    // 中序, 将空缺处 null 补为 -1, 注意叶子节点子节点的 null 不用处理
    private void inorderTraver(TreeNode root, boolean isLeaf) {
        if (root == null) {
            if (!isLeaf) {
                res.add(-1);
            }
            return;
        }
        boolean isCurrentLeaf = root.left == null && root.right == null;
        inorderTraver(root.left, isCurrentLeaf);
        res.add(root.val);
        inorderTraver(root.right, isCurrentLeaf);
    }

    // 递归. 两个树互为镜像: 它们的两个根结点具有相同的值; 每个树的右子树都与另一个树的左子树镜像对称
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // 迭代. BFS. 将左右子树节点依次加入队列, 每次从队列中取出一对节点, 判断是否相等,
    // 若相等, 则将该节点的子节点按镜像顺序加入队列(左子树的左节点和右子树的右节点, 左子树的右节点和右子树的左节点)
    public boolean isSymmetric0(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;   // 都为空, 继续比较下一对
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
