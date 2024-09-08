package Test.T_9_8_PDD;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        int res = 0;
        int[] f = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == 'A') {
                f[i] = 1;
            } else {
                f[i] = -1;
            }
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == 'A') {
                    f[j] = f[j - 1] + 1;
                } else {
                    f[j] = f[j - 1] - 1;
                }
                if (f[j] == 0) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        System.out.println(res);
    }
}
