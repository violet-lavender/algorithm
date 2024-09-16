package Graph.MST;

import java.util.Arrays;

// MST: 最小生成树
// Kruskal算法: (并查集 + 贪心)
// 1. 按权重排序所有的边
// 2. 选择一条权重最小的边, 如果这条边的两个顶点不属于同一个连通分量, 则将这条边加入最小生成树中, 并将这两个顶点所在的连通分量合并
// 3. 重复步骤2, 直到最小生成树中包含了所有顶点
// 时间复杂度: O(E logE)
// 如果挑选边时, 一条边的两个节点已经连通, 则会出现环; 如果最后的连通分量大于 1, 说明形成的是树林而不是最小生成树
public class Kruskal {

    public int kruskalMST(int[][] edges, int n) {
        UF uf = new UF(n);
        Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);
        int mst = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (uf.connected(u, v)) {
                continue;
            }
            uf.union(u, v);
            mst += edge[2];
            if (uf.count() == 1) {
                break;
            }
        }
        return uf.count() == 1 ? mst : -1;
    }
}

class UF {
    private int[] parent;
    private int count;

    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);
        if (p1 == p2) {
            return;
        }
        parent[p1] = p2;
        count--;
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }

    public int count() {
        return count;
    }
}
