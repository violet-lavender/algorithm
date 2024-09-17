package Test.T_9_14_JingDong;

import java.util.*;

// MST 问题
// 使所有城市连通所需的最少年份数. 由于所有城市同时施工, 施工速度相同, 因此我们需要找到最小生成树(MST)中最大边权值, 即最长的相遇时间.
public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        City[] cities = new City[n];
        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            cities[i] = new City(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = Math.sqrt((cities[i].x - cities[j].x) * (cities[i].x - cities[j].x) + (cities[i].y - cities[j].y) * (cities[i].y - cities[j].y));
                double time = distance / 2;
                edges.add(new Edge(i, j, time));
            }
        }
        Collections.sort(edges);
        UF uf = new UF(n);
        double time = 0;
        for (Edge edge : edges) {
            if (uf.connected(edge.u, edge.v)) {
                continue;
            }
            uf.union(edge.u, edge.v);
            time = Math.max(time, edge.w);
            if (uf.count() == 1) {
                break;
            }
        }
        System.out.println((int) Math.ceil(time));
    }
}

class City {
    int x;
    int y;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int u;
    int v;
    double w;

    public Edge(int u, int v, double w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(w, o.w);
    }
}

class UF {
    int[] parent;
    int count;

    public UF(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi == pj) {
            return;
        }
        parent[pi] = pj;
        count--;
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }

    public int count() {
        return count;
    }
}
