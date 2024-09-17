package Test.T_9_14_XiaoHongshu;

import java.util.*;

// u 到 v 的路径异或和 = u 到 root 的路径异或和 ^ v 到 root 的路径异或和
public class T3 {
    // 每个节点到 root 的路径异或和并统计数量
    static Map<Long, Integer> map;
    // 从 root 到每个节点的路径异或和
    static long[] d;
    // 邻接表
    static List<Pair>[] paths;
    static boolean[] visited;

    static class Pair {
        int v;
        long w;

        public Pair(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    private static void dfs(int u) {
        for (Pair path : paths[u]) {
            if (visited[path.v]) {
                continue;
            }
            d[path.v] = d[u] ^ path.w;
            map.put(d[path.v], map.getOrDefault(d[path.v], 0) + 1);
            visited[path.v] = true;
            dfs(path.v);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] firstLine = in.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);
        map= new HashMap<>();
        // 节点编号从 1 开始
        paths = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            paths[i] = new ArrayList<>();
        }
        d = new long[n + 1];
        Arrays.fill(d, -1);
        d[1] = 0;
        visited = new boolean[n + 1];
        visited[1] = true;
        for (int i = 1; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            long w = Long.parseLong(line[2]);
            paths[u].add(new Pair(v, w));
            paths[v].add(new Pair(u, w));
        }
        dfs(1);
        map.put(0L, 1);
        while (q-- > 0) {
            String[] line = in.nextLine().split(" ");
            int u = Integer.parseInt(line[0]);
            long k = Long.parseLong(line[1]);
            System.out.println(map.getOrDefault(d[u] ^ k, 0));
        }
    }
}
