package String.Convert;

// 字符串转换整数(atoi)
public class Atoi {

    public static int myAtoi(String s) {
        int sign = 1;
        char[] chs = s.toCharArray();
        int n = chs.length;
        int i = 0;
        int num = 0;
        while (i < n && chs[i] == ' ') {
            i++;
        }
        if (i < n) {
            if (chs[i] == '-') {
                sign = -1;
                i++;
            } else if (chs[i] == '+') {
                i++;
            }
        }
        while (i < n && Character.isDigit(chs[i])) {
            int re = Character.getNumericValue(chs[i]);
            // sign = 1, num = num * 10 -re > max, 则正溢出
            if (sign == 1 && num > ((Integer.MAX_VALUE - re) / 10)) {
                return Integer.MAX_VALUE;
            }
            // sign = -1, num = num * 10 - re < min, 则负溢出
            if (sign == -1 && num < ((Integer.MIN_VALUE + re) / 10)) {
                return Integer.MIN_VALUE;
            }
            num = num * 10 + re * sign;    //-42, - 4 * 10 + 2 * (- 1), 而不是 (- 4 * 10 + 2) *(- 1)
            i++;
        }
        return num;
    }
}
