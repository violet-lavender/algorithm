package BFS;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// 打开转盘锁, 双向 BFS
// 双向 BFS (双向 BFS 必须知道终点), 从起点和终点同时开始扩散, 当两边有交集时停止
// 延迟更新 visited: 在双向BFS中, visited的更新通常是在节点实际被扩展时进行的, 而不是在加入队列时(立即更新)

/* 单向BFS: visited 的更新时机在加入队列时, 保证每个节点只被最早的一层访问到, 避免重复搜索, 确保最短路径.
双向BFS: visited的更新时机在节点扩展时, 避免误判搜索前沿的相遇, 并确保两个方向的搜索能够动态平衡, 正确判断路径的最短性. */

// 事实上, 当有新的节点入队, 当前节点才真正算是被拓展, 当前节点被遍历到并不代表被拓展,
// 所以 visited.add(cur) 应该放在新节点入队之后, 而不是当前节点被遍历到之前
public class OpenLockPro {

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        Collections.addAll(deads, deadends);
        // 用集合不用队列, 可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        q1.add("0000");
        Set<String> q2 = new HashSet<>();
        q2.add(target);
        Set<String> visited = new HashSet<>();
        int step = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 总是扩散较小的集合
            while (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            // 哈希集合在遍历过程中不能修改(不像队列那样具有方向性), 用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();
            for (String cur : q1) {
                if (deads.contains(cur))
                    continue;
                // 有交集, 到达终点
                if (q2.contains(cur))
                    return step;
                //visited.add(cur);   // 延迟更新 visited, 但是被遍历之前更新是错误时机
                for (int j = 0; j < 4; j++) {
                    String up = upOne(cur, j);
                    String down = downOne(cur, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                        visited.add(cur);  // 延迟更新 visited, 只有节点真正被扩展时才更新 visited
                    }
                    if (!visited.contains(down)) {
                        temp.add(down);
                        visited.add(cur);    // 延迟更新 visited, 只有节点真正被扩展时才更新 visited
                    }
                }
            }
            step++;
            // temp 相当于 q1(事实上是 q1 的扩散结果), 这里交换 q1、 q2, 下一轮 while 就是扩散 q2, 实现轮流扩散, 双向 BFS
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

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
