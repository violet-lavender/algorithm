package Test.T_9_19_XieCheng;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            System.out.println(maxValue(n, m, k));
        }
    }

    private static long maxValue(int n, int m, int k) {
        long res = 0;
        Node cur = new Node(0, 0);
        while (k > 0) {
            cur = getMax(cur, n, m);
            res += (long) cur.x * m + cur.y;
            k--;
        }
        return res;
    }

    private static Node getMax(Node node, int n, int m) {
        long l = 0, r = 0, u = 0, d = 0;
        if (node.x - 1 >= 0) {
            l = node.y + (long) (node.x - 1) * m;
        }
        if (node.x + 1 < n) {
            r = node.y + (long) (node.x + 1) * m;
        }
        if (node.y - 1 >= 0) {
            u = node.y -1 + (long) (node.x) * m;
        }
        if (node.y + 1 < m) {
            d = node.y + 1 + (long) (node.x) * m;
        }
        long max = Math.max(Math.max(l, r), Math.max(u, d));
        if (max == l) {
            return new Node(node.x - 1, node.y);
        } else if (max == r) {
            return new Node(node.x + 1, node.y);
        } else if (max == u) {
            return new Node(node.x, node.y - 1);
        } else {
            return new Node(node.x, node.y + 1);
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
