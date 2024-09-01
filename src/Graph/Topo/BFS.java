package Graph.Topo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Kahn 算法:
找到图中所有入度为 0 (即没有前驱)的顶点, 加入一个队列中;
依次从队列中取出顶点, 输出该顶点, 并将该顶点的所有邻接顶点的入度减 1(某个前驱已完成);
如果某个邻接顶点的入度减为 0, 将其加入队列中;
重复以上步骤, 直到队列为空. 如果输出的顶点数等于图中的顶点数, 则成功得到一个拓扑排序; 否则说明图中存在环. */
// 课程表. 拓扑排序.
public class BFS {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 计算每个顶点的入度
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            indegree[to]++;
        }
        // 入度为 0 的顶点加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[count] = cur;
            count++;
            for (int nxt : graph[cur]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0) {
                    queue.offer(nxt);
                }
            }
        }
        if (count != numCourses) {
            return new int[]{};
        }
        return res;
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new LinkedList<>();
        for (int[] edge : edges) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
