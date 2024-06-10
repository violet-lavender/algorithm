package UnionFind;

// 并查集 —— 动态连通性, 用树林来表示图的动态连通性, 用数组来实现这个树林
// 连通性: 等价关系 —— 自反、对称、传递
// 在优化上, 可以使用size数组记录每棵树的节点数, 将小树接到大树下面, 进行平衡优化
// 更好的优化是在find函数中进行路径压缩, 将所有节点都直接连到根节点上
public class UF {
    // 记录连通分量
    private int count;
    // 存储每个节点的父节点, 根节点的父节点是它自己
    private int[] parent;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

    }

    // 返回某个节点 x 的根节点, 并通过递归进行路径压缩, 将所有节点都直接连到根节点上
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    // 将 p 和 q 连接, 将其中一个节点的根节点接到另一个节点的根节点上
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        parent[rootQ] = parent[rootP];
        count--;
    }

    // 判断 p 和 q 是否连通, 有相同的根节点则连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    // 返回图中有多少连通分量
    public int count() {
        return count;
    }
}
