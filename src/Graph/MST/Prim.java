package Graph.MST;

import java.util.List;
import java.util.PriorityQueue;

// MST: 最小生成树
// Prim算法: (BFS + 贪心)
// 每次切分都能找到最小生成树的一条边, 然后又进行新一轮的切分, 直到所有顶点都被切分到最小生成树中
// 时间复杂度: O(E logE)
public class Prim {
    private PriorityQueue<int[]> qp;
    private boolean[] inMST;
    private int weightSum = 0;
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph) {
        this.graph = graph;
        this.qp = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int n = graph.length;
        this.inMST = new boolean[n];

        // 任意节点都可以作为起点, 不妨从0开始
        inMST[0] = true;
        while (!qp.isEmpty()) {
            int[] edge = qp.poll();
            int u = edge[0], v = edge[1], w = edge[2];
            if (inMST[v]) {
                continue;
            }
            inMST[v] = true;
            weightSum += w;
            cut(v);
        }
    }

    private void cut(int u) {
        for (int[] edge : graph[u]) {
            int v = edge[1];
            // 若 v 已经在最小生成树中, 则跳过(防止产生环)
            if (inMST[v]) {
                continue;
            }
            qp.offer(edge);
        }
    }

    public int weightSum() {
        return weightSum;
    }

    public boolean isMST() {
        for (int i = 1; i < inMST.length; i++) {
            if (!inMST[i]) {
                return false;
            }
        }
        return true;
    }
}
