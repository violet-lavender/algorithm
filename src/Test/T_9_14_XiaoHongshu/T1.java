package Test.T_9_14_XiaoHongshu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 异或的逆元特性, a ^ b = c ---> b ^ c = a, a ^ c = b
// 异或的自反性, a ^ a = 0, a ^ 0 = a
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            arr[i] = x;
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        long res = 0;
        for (int x : arr) {
            if (map.containsKey(x ^ k)) {
                res += map.get(x ^ k);
                if (k == 0) {
                    res--;
                }
            }
        }
        System.out.println(res/2);
    }
}
