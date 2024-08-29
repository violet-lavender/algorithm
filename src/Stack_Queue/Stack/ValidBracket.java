package Stack_Queue.Stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

// 有效的括号
public class ValidBracket {

    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1)
            return false;
        // 右括号匹配左括号, 右括号作 key
        HashMap<Character, Character> map = new HashMap<>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != map.get(c))
                    return false;
                stack.pop();
            }else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
