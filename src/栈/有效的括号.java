package 栈;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class 有效的括号 {

    private boolean checks0(char c) {
        if (c == '}' || c == ']' || c == ')') return false;
        return true;
    }

    public boolean isValid(String str) {
        if (str == null || str.length() == 0 || str.length() % 2 != 0) return false;
        char[] chars = str.toCharArray();
        if (!checks0(chars[0])) return false;
        for (char c : chars) {

        }
        Stack<Character> stack = new Stack<>();

        return false;
    }

    public static void main(String[] args) {

    }
}
