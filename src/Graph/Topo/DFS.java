package Graph.Topo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 对图中的每一个未访问的顶点进行 DFS;
在 DFS 过程中, 当一个顶点的所有邻接顶点都已经处理完时, 将该顶点加入一个栈中(后序处入栈);
最终, 从栈顶到栈底的顺序即为一个拓扑排序;
如果在 DFS 过程中发现有一条回边(即访问到了一个已经在当前路径上的顶点), 则说明图中有环, 无法进行拓扑排序.
即 对于 1 -> 2表示先 1 后 2, 即 1 被 2 依赖这种情况, 后序遍历的反转就是拓扑排序的结果(用栈直接表示后序遍历的反转或者列表遍历后反转都可). */
// 课程表. 拓扑排序.
public class DFS {
    List<Integer>[] graph;
    List<Integer> postorder;
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        postorder = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            traverse(graph, i);
        if (hasCycle)
            return new int[]{};
        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            res[i] = postorder.get(i);
        return res;
    }

    private void buildGraph(int n, int[][] edges) {
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new LinkedList<>();
        for (int[] edge : edges) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
    }

    private void traverse(List<Integer>[] graph, int s) {
        if (onPath[s])
            hasCycle = true;
        if (visited[s] || hasCycle)
            return;
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s])
            traverse(graph, t);
        postorder.add(s);
        onPath[s] = false;
    }
}