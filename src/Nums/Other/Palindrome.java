package Nums.Other;

// 回文数问题
public class Palindrome {

    // 转字符串, 需要额外空间
    public boolean isPalindromeNo(int x) {
        char[] chs = Integer.toString(x).toCharArray();
        int left = 0, right = chs.length - 1;
        while (left < right) {
            if (chs[left] != chs[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 反转数字 —— 可能溢出(事实上回文数不会溢出)
    // 反转后半部分即可
    // 整个过程不断将原始数字除以 10, 然后给反转后的数字乘 10, 当原始数字小于或等于反转后的数字时, 就意味着已经处理了一半位数的数字了
    public boolean isPalindrome(int x) {
        // 负数不可能是回文数; 除了 0 以外, 所有个位是 0 的数字不可能是回文, 因为最高位不等于 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNum = 0;
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x = x / 10;
        }
        // 当数字长度为奇数时, 通过 revertedNumber / 10 去除处于中位的数字. 处于中位的数字不影响回文(它总是与自己相等)
        return x == revertedNum || x == revertedNum / 10;
    }
}
