package String.SubString;

// 回文串问题
public class Palindrome {

    // 回文串判断、典型左右指针
    public boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }

    // 最长回文子串
    public String longestPalindrome(String s) {
        String res = "";
        // 这里 i < s.length , 不能由于 i+1 而担心 i = length - 1 时, i + 1 = length 越界, 在palindrome中明确处理了越界问题
        // 而i < s.length - 1, 看似不用处理i=s.length——不可能最后一个字母成为回文串的中心,
        // 但当 length == 0, 第一个字母即为最后一个字母, 循环无法进行—— i = 0 < 0, 返回空, 无法正确处理
        for(int i = 0; i < s.length() ; i++){
            String s1 = palindrome(s,i,i);
            String s2 = palindrome(s,i,i+1);
            if(res.length() < s1.length()){
                res = s1;
            }
            if(res.length() < s2.length()){
                res = s2;
            }
        }
        return res;
    }

    // 从中间向两端的拓展的左右指针, 一般在回文串类问题中常见
    public String palindrome(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        // 返回以s[l]和s[r]为中心的最长回文串. 若i=l, 则奇数长, 否则为偶数长, 巧妙求解
        return s.substring(l + 1, r);   // 注意substring是左闭右开[begin,end)
    }
}
