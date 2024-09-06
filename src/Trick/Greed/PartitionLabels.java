package Trick.Greed;

import java.util.ArrayList;
import java.util.List;

// 划分字母区间
public class PartitionLabels {

    // 对于当前字母的最后一次出现的下标位置 end, 当前片段的结束下标一定不会小于 end, 当访问到 end 时, 当前片段结束.
    // [start, end] 双闭区间, 长度为 end - start + 1.
    public List<Integer> partitionLabels(String s) {
        // 每一个字母最后一次出现的下标位置
        int[] last = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
