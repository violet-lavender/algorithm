package Dichotomy;

// x 的平方根
public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int left = 0, right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
