package BFS;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 在每个树行中找最大值, 层次遍历, 典型的BFS
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();    //返回空列表
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = queue.peek().val;     //注意基值不要赋0,可能有负值,也可以赋足够小的数,如Integer.MIN_VALUE
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
