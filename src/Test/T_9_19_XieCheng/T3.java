package Test.T_9_19_XieCheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int l = in.nextInt();
        int[] arr = new int[n];
        int minAbility = Integer.MAX_VALUE;
        int maxAbility = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            minAbility = Math.min(minAbility, arr[i]);
            maxAbility = Math.max(maxAbility, arr[i]);
        }
        int low = minAbility;
        int high = minAbility + (int) 1e9;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (isFeasible(arr, k, l, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low);
    }

    private static boolean isFeasible(int[] arr, int k, int l, int mid) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < mid) {
                positions.add(i);
            }
        }
        int sessions = 0;
        int idx = 0;
        int size = positions.size();
        while (idx < size) {
            sessions++;
            int startPos = positions.get(idx);
            int endPos = startPos + l - 1;
            while (idx < size && positions.get(idx) <= endPos) {
                idx++;
            }
        }
        return sessions <= k;
    }
}
