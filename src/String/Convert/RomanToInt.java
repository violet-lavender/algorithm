package String.Convert;

import java.util.HashMap;
import java.util.Map;

// 罗马数组转整数
public class RomanToInt {

    // 当前位置的元素比下个位置的元素小, 就减去当前值, 否则加上当前值
    public int romanToIntPro(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            if (i < s.length() - 1 && cur < map.get(s.charAt(i + 1)))
                res = res - cur;
            else
                res = res + cur;
        }
        return res;
    }
}
