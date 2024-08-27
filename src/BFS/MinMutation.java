package BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 最小基因变化. 也是序列转换类问题.
public class MinMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> list = new HashSet<>(Arrays.asList(bank));
        if (!list.contains(endGene))
            return -1;
        Set<String> q1 = new HashSet<>();
        q1.add(startGene);
        Set<String> q2 = new HashSet<>();
        q2.add(endGene);
        Set<String> visited = new HashSet<>();
        int step = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            Set<String> temp = new HashSet<>();
            for (String cur : q1) {
                if (q2.contains(cur))
                    return step;
                for (String nxt : list) {
                    if (isNxt(cur, nxt) && !visited.contains(nxt)) {
                        temp.add(nxt);
                        visited.add(cur);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    public boolean isNxt(String s1, String s2) {
        boolean res = false;
        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (res)
                    return false;
                res = true;
            }
        }
        return res;
    }
}
