package UnionFind;

// 无向图中连通分量的数目
public class CountComponents {
    public int countComponents(int n, int[][] edges){
        UF uf = new UF(n);
        for(int[] e: edges)
            uf.union(e[0], e[1]);
        return uf.count();
    }
}
