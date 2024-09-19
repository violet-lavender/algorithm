package Test.T_9_19_XieCheng;

import java.util.*;

public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long k = in.nextLong();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        int ans = n;
        for (int l = 0, r = 0; r < n; r++) {
            if (r - l + 1 == m) {
                if (nums[r] - nums[l] <= k) {
                    ans--;
                }
                l++;
            }
        }
        System.out.println(ans);
    }
}
