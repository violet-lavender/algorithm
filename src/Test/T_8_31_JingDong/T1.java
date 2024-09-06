package Test.T_8_31_JingDong;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = str.length();
        for (int i = n - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == 'z') {
              if (i == 0) {
                  System.out.println("-1");
              } else {
                  continue;
              }
            } else {
                System.out.print(str.substring(0, i) + (char) (c + 1));
                for (int j = i + 1; j < n; j++) {
                    System.out.print('a');
                }
                break;
            }
        }
        in.close();
    }
}
