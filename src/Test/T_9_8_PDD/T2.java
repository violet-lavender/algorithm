package Test.T_9_8_PDD;

import java.util.ArrayList;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++) {
            String[] line = in.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            ArrayList<Integer> arr = new ArrayList<>();
            String[] str = in.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr.add(Integer.parseInt(str[j]));
            }
            System.out.println(solve(arr, k));
        }
    }

    public static long solve(ArrayList<Integer> arr, int k) {
        for (int i = 0; i < k; i++) {
            int index = getIndex(arr);
            int max = getMax(arr);
            if (index == arr.size() - 1 || max == 0) {
                arr.add(max);
            } else {
                arr.set(index, max);
            }
        }
        long res = 0;
        for (Integer integer : arr) {
            res += integer;
        }
        return (res + 1000000007) % 1000000007;
    }


    // 最大子数组和
    public static int getMax(ArrayList<Integer> arr) {
        int n = arr.size();
        int res = arr.get(0);
        int sum = arr.get(0);
        for (int i = 1; i < n; i++) {
            if (sum + arr.get(i) > sum) {
                sum += arr.get(i);
            } else {
                sum = arr.get(i);
            }
            res = Math.max(res, sum);
        }
        return Math.max(res, 0);
    }

    public static int getIndex(ArrayList<Integer> arr) {
        int n = arr.size();
        int res = arr.get(0);
        int sum = arr.get(0);
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (sum + arr.get(i) > sum) {
                sum += arr.get(i);
            } else {
                sum = arr.get(i);
            }
            if (sum > res) {
                res = sum;
                index = i;
            }
        }
        return index;
    }
}
