package TreeNode.BST;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 二叉搜索树种的众数
public class FindMode {

    List<Integer> list = new ArrayList<>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        ldf(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void ldf(TreeNode root) {
        if (root == null) {
            return;
        }
        ldf(root.left);
        update(root.val);
        ldf(root.right);
    }

    public void update(int x) {
        if (x == base) {
            count++;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            list.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(base);
        }
    }
}
