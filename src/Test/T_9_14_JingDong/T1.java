package Test.T_9_14_JingDong;

import java.util.List;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        long rSum = 0, lSum = 0, res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            rSum += arr[i];
        }
        for (int i = 0; i < n - 1; i++) {
            lSum += arr[i];
            rSum -= arr[i];
            res = Math.min(res, lSum * rSum);
        }
        System.out.println(res);
    }
}
