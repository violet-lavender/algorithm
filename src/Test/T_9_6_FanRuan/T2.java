package Test.T_9_6_FanRuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T2 {

    // 立方数之和.
    public ArrayList<Integer> MinimumK (int N) {
        // dp[i], 即最少的立方数个数, 使得和等于 i
        int[] dp = new int[N + 1];
        // pre[i], 为了组成 i 所选择的最后一个立方数
        int[] pre = new int[N + 1];
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 可能用到的立方数
        List<Integer> cubes = new ArrayList<>();
        for (int i = 1; i * i * i < N + 1; i++) {
            cubes.add(i);
        }
        for (int i = 1; i < N + 1; i ++) {
            for (int cubeRoot : cubes) {
                int cube = cubeRoot * cubeRoot * cubeRoot;
                if (i >= cube) {
                    if (dp[i - cube] + 1 < dp[i]) {
                        dp[i] = dp[i - cube] + 1;
                        pre[i] = cubeRoot;
                    }
                } else {
                    break;
                }
            }
        }
        while (N > 0) {
            res.add(pre[N]);
            N -= pre[N] * pre[N] * pre[N];
        }
        res.sort(Collections.reverseOrder());
        return res;
    }
}
