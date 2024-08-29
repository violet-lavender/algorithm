package Nums.Hash;

import java.util.HashMap;
import java.util.Map;

// 黑名单中的随机数
// 哈希. 对于 [0, n − m) 的黑名单数, 将其映射到 [n − m, n) 的白名单数上. 每次 pick() 时, 仍在 [0, n − m) 范围内取随机整数
public class Solution {
    int sz;
    Map<Integer, Integer> map;

    public Solution(int N, int[] blacklist) {
        sz = N - blacklist.length;
        map = new HashMap<>();
        for (int b : blacklist)
            map.put(b, 1000);
        int last = N - 1;
        // 将 [0, sz) 的黑名单映射到 [sz, n) 的白名单
        for (int b : blacklist) {
            // b 在 [sz, n) 则直接忽略
            if (b >= sz)
                continue;
            // 跳过所有黑名单中的数字
            // 找 [sz, n) 的白名单,注意 last 是从 n-1 开始的, 且 sz = n - m, 那么在该循环中 last >= sz 是恒成立的, 即满足 [sz, n)
            while (map.containsKey(last))
                last--;
            // 将黑名单中的索引映射到合法数字
            map.put(b, last);
            last--;
        }
    }

    //命中了黑名单则需要被映射到其他位置, 没命中黑名单则直接返回
    public int pick() {
        int index = (int) (Math.random() * sz);
        if (map.containsKey(index))
            return map.get(index);
        return index;
    }
}