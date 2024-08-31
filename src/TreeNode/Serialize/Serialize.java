package TreeNode.Serialize;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//二叉树的序列化
/*
            1
          /   \
        2      3
      /       /  \
    4        2    4
            /
           4
 */
// 第一种方法是使用层序遍历的方法进行序列化 —— 1, 2, 3, 4, null, 2, 4, null, null, 4
// 第二种方法是使用递归的方法进行序列化. 可以将一棵以 x 为根节点值的子树序列化为 —— x(左子树的序列化结果)(右子树的序列化结果) —— 显然是前序
//  左右子树分别递归地进行序列化. 如果子树为空, 那么序列化结果为空串. —— 1(2(4()())())(3(2(4()())())(4()()))
// 除此之外, 前序、中序、后序都有序列化, 但是中序无法反序列化.
// 二叉树的序列化和反序列化, 给出前序序列化的示例
public class Serialize {

    String SEP = ",", NULL = "null";

    public String preSerialize(TreeNode root) {
        StringBuilder sB = new StringBuilder();
        preSerialize(root, sB);
        return sB.deleteCharAt(sB.length() - 1).toString();
    }

    private void preSerialize(TreeNode root, StringBuilder sB) {
        if (root == null) {
            sB.append(NULL).append(SEP);
            return;
        }
        sB.append(root.val).append(SEP);
        preSerialize(root.left, sB);
        preSerialize(root.right, sB);
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> nodeList = new ArrayList<>(Arrays.asList(nodes));
        return deserialize(nodeList);
    }

    private TreeNode deserialize(List<String> nodes) {
        if (nodes.get(0).equals(NULL)) {
            nodes.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
