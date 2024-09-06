package Test.T_8_31_JingDong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T2 {

    // 距离差为偶数一定可以通过操作 2 得到, 距离差为奇数的个数除以 2, 即为答案
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.nextLine());
        }
        int[] tar = arr.clone();
        Arrays.sort(tar);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            map.put(tar[i], i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((i - map.get(arr[i])) % 2 != 0) {
                res++;
            }
        }
        System.out.println(res / 2);
    }
}
