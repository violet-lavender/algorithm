package String.Other;

// 反转字符串中的单词
public class ReverseWords {

    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            res.append(str[i]).append(" ");
        }
        // trim 处理前导空格和尾随空格
        return res.toString().trim();
    }

    // 另一种思路: 先将整个字符串反转, 然后将每个单词分别反转
}
