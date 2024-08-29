package Nums.Num;

// 整数反转
public class Reverse {

    public static int reverse(int x){
        int res = 0;
        while( x != 0){
            // 判断 Integer 是否溢出的重要不等式
            if(res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10){
                return 0;
            }
            // int, 模 10 取余求得末位, 除以 10 舍去末位
            int digit = x % 10;
            x = x / 10;
            res = res * 10 + digit;
        }
        return res;
    }
}
