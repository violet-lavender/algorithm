package String.Other;

import java.util.Arrays;

// 最长公共前缀
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> o1.length() - o2.length());
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i))
                    return sB.toString();
            }
            sB.append(strs[0].charAt(i));
        }
        return sB.toString();
    }
}
