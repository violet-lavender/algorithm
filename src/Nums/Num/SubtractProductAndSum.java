package Nums.Num;

// 整数的各位积差之和
public class SubtractProductAndSum {

    // 转 String, 整数的对位操作除转字符串外也可直接用 / 和 %
    public int subtractProductAndSum(int n) {
        String s = Integer.toString(n);
        int add = 0, mul = 1;
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - '0';
            add = add + value;
            mul = mul * value;
        }
        return mul - add;
    }
}
