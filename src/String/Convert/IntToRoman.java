package String.Convert;

// 整数转罗马数字
public class IntToRoman {

    // 填充, 从前往后太麻烦, 直接从后往前, 最后翻转
    public String intToRoman(int num) {
        String s = Integer.toString(num);
        StringBuilder res = new StringBuilder();
        String[][] map = {
                {"XI", "VI", "V", "I"}, {"CX", "LX", "L", "X"}, {"MC", "DC", "D", "C"}
        };
        for (int k = s.length() - 1, x = 0; k >= 0; k--, x++) {
            int i = s.charAt(k) - '0';
            if (i == 0)
                continue;
            if (s.length() == 4 && k == 0) {
                res.append("M".repeat(i));
                break;
            }
            if (i == 9)
                res.append(map[x][0]);
            else if (i == 4)
                res.append(map[x][1]);
            else {
                int j1 = i / 5;
                int j2 = i % 5;
                res.append(map[x][2].repeat(j1));
                res.append(map[x][3].repeat(j2));
            }
        }
        return res.reverse().toString();
    }

    // 标准解答1, 类似近似贪心解零钱问题的过程
    public String intToRomanPro1(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                res.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return res.toString();
    }

    // 标准解答2. 硬编码, 暴力而简易
    public String intToRomanPro2(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num / 1000] +
                hundreds[num % 1000 / 100] +
                tens[num % 100 / 10] +
                ones[num % 10];
    }
}
