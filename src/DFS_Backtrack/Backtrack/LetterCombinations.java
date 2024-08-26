package DFS_Backtrack.Backtrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// 电话号码的字母组合
public class LetterCombinations {

    List<String> res = new LinkedList<>();
    StringBuilder track = new StringBuilder();
    HashMap<Integer,String> map;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        map = new HashMap<>(){{
           put(2,"abc");
           put(3,"def");
           put(4,"ghi");
           put(5,"jkl");
           put(6,"mno");
           put(7,"pqrs");
           put(8,"tuv");
           put(9,"wxyz");
        }};
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int index) {
        if (index == digits.length()) {
            res.add(track.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = map.get(digit);
        for (char c : letters.toCharArray()) {
            track.append(c);
            backtrack(digits, index + 1);
            track.deleteCharAt(track.length() - 1);
        }
    }
}
