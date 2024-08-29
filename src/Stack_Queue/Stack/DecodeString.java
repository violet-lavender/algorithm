package Stack_Queue.Stack;

import java.util.Deque;
import java.util.LinkedList;

// 字符串解码
/* 如果当前的字符为数位, 解析出一个数字（连续的多个数位）并进栈;
如果当前的字符为字母或者左括号, 直接进栈;
如果当前的字符为右括号, 开始出栈, 一直到左括号出栈, 出栈序列反转后拼接成一个字符串, 此时取出栈顶的数字(左括号前一定是数字), 即该字符串应该出现的次数, 根据这个次数和字符串构造出新的字符串并进栈.
重复如上操作, 最终将栈中的元素按照从栈底到栈顶的顺序拼接起来. */
public class DecodeString {

    // 双栈解法
    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        // 用 StringBuilder 提高字符串拼接效率
        Deque<StringBuilder> strStack = new LinkedList<>();
        int num = 0;
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i++) - '0');
                }
                numStack.push(num);
                num = 0;
            } else if (s.charAt(i) == '[') {
                // 遇到 "[" 即需要处理一个新的嵌套编码
                strStack.push(new StringBuilder(str));
                str.setLength(0);
                i++;
            } else if (s.charAt(i) == ']') {
                // 遇到 "]" 即结束当前的嵌套编码并进行拼接
                StringBuilder tmp = new StringBuilder(strStack.pop());
                int n = numStack.pop();
                while (n-- > 0) {
                    tmp.append(str);
                }
                str = tmp;
                i++;
            } else {
                str.append(s.charAt(i++));
            }
        }
        return str.toString();
    }
}
