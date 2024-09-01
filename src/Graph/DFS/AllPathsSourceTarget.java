package Graph.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 所有可能的路径, 有向无环图, 从节点 0 到节点 n-1 的路径, dfs
// 邻接表 graph[i]: 是一个从节点 i 可以访问的所有节点的列表(即从节点 i 到节点 graph[i][j]存在一条有向边)
public class AllPathsSourceTarget {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        dfs(graph, 0);
        return res;
    }

    private void dfs(int[][] graph, int i) {
        path.addLast(i);
        if (i == n - 1) {
            res.add(new ArrayList<>(path));
            // 注意这里 return 时要 removeLast()
            path.removeLast();
            return;
        }
        for (int j : graph[i])
            dfs(graph, j);
        path.removeLast();
    }
}
