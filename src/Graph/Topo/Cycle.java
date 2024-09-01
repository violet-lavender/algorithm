package Graph.Topo;

import java.util.LinkedList;
import java.util.List;

// 课程表. 能否完成所有课程, 循环依赖问题, 即是否存在环.
// 除了 dfs 外, 还可以用拓扑排序来判断是否有环(有向无环图一定可以拓扑排序, 有环则不可以).
public class Cycle {

    List<Integer>[] graph;
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            traverse(graph, i);
        return !hasCycle;
    }

    //先建图, 邻接表
    private void buildGraph(int n, int[][] edges) {
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new LinkedList<>();
        for (int[] edge : edges) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
    }

    // 如果 visited[i] == true, 说明 i 节点及之后的状态已经被判断过了(被遍历过), 无需再进行延伸, 所以visited[i]不需要回溯.
    private void traverse(List<Integer>[] graph, int s) {
        // 出现环
        if (onPath[s])
            hasCycle = true;
        if (visited[s] || hasCycle)
            return;
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s])
            traverse(graph, t);
        onPath[s] = false;
    }
}
