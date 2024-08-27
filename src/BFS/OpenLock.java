package BFS;

import java.util.*;

// 打开转盘锁
public class OpenLock {

    // 可以不需要 dead 集合, 直接把死亡密码初始化到 visited 中, 就永远也不会添加这些死亡密码入队列了
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        Set<String> deads = new HashSet<>();  // 记录死亡密码
        Collections.addAll(deads, deadends);
        Set<String> visited = new HashSet<>();  // 记录已经穷举过的密码,防止走回头路(会死循环)
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                //转到死亡密码直接跳过这个状态
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;
                // 将一个节点的相邻队列加入队列, 一个状态的四个数字, 每个都可以向上向下转
                for (int j = 0; j < 4; j++) {
                    String up = upOne(cur, j);
                    String down = downOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 向上、向下辗转一个数字, 注意 0 和 9 的特殊情况
    private String upOne(String s, int i) {
        char[] chs = s.toCharArray();
        if (chs[i] == '9')
            chs[i] = '0';
        else
            chs[i] = (char) (chs[i] + 1);
        return new String(chs);
    }

    private String downOne(String s, int i) {
        char[] chs = s.toCharArray();
        if (chs[i] == '0')
            chs[i] = '9';
        else
            chs[i] = (char) (chs[i] - 1);
        return new String(chs);
    }
}
