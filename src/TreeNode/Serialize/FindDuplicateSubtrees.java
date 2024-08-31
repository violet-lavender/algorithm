package TreeNode.Serialize;

import TreeNode.TreeNode;

import java.util.*;

// 寻找重复的子树. 序列化. 返回根节点即可.
// 使用递归的方法进行序列化. 将一棵以 x 为根节点值的子树序列化为 —— x(左子树的序列化结果)(右子树的序列化结果)
public class FindDuplicateSubtrees {

    Map<String, TreeNode> map = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfsSerialize(root);
        return new ArrayList<>(repeat);
    }

    // 序列化. x(左子树的序列化结果)(右子树的序列化结果), 显然前序, 比较则放在后序.
    private String dfsSerialize(TreeNode node) {
        if (node == null)
            return "";
        StringBuilder sB = new StringBuilder();
        sB.append(node.val);
        sB.append("(");
        sB.append(dfsSerialize(node.left));
        sB.append(")(");
        sB.append(dfsSerialize(node.right));
        sB.append(")");
        String serial = sB.toString();

        if (map.containsKey(serial))
            repeat.add(map.get(serial));
        else
            map.put(serial, node);
        return serial;
    }
}
