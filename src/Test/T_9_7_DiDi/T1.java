package Test.T_9_7_DiDi;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while (n > 0) {
            String[] line = in.nextLine().split(" ");
            System.out.print(solve(Integer.parseInt(line[0]), Integer.parseInt(line[1])) + " ");
            n--;
        }
        in.close();
    }

    private static int solve(int n, int m) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return m;
        }
        return 2 * m;
    }
}
