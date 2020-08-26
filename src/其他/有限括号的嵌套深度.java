package 其他;

import java.util.Stack;

public class 有限括号的嵌套深度 {

//    public static int[] maxDepthAfterSplit(String seq) {
//        char[] seqs = seq.toCharArray();
//        if (seqs.length == 0 || seq == null) {
//            return null;
//        }
//        int[] ans = new int[seqs.length];
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < seqs.length; i++) {
//            if (seqs[i] == '(') {
//                ans[i] = stack.size() % 2;
//                stack.push('(');
//            } else {
//                stack.pop();
//                ans[i] = stack.size() % 2;
//            }
//        }
//        return ans;
//    }

//    public static int[] maxDepthAfterSplit(String seq) {
//        int[] ans = new int [seq.length()];
//        int idx = 0;
//        for(char c: seq.toCharArray()) {
//            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
//        }
//        return ans;
//    }

    public static int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int [seq.length()];

        for (int i = 0; i < seq.length(); i++) {
            if (i == 0) {
                ans[0] = 0;
                continue;
            }
            if (seq.charAt(i) == '(') {
                //为左括号
                if (seq.charAt(i - 1) == '(') {
                    //前一个也为左括号
                    ans[i] = ans[i - 1] ^ 1;
                } else {
                    //前一个为右括号
                    ans[i] = ans[i - 1];
                }
            } else {
                //为右括号
                if (seq.charAt(i - 1) == '(') {
                    //前一个为左括号
                    ans[i] = ans[i - 1];
                } else {
                    //前一个也为右括号
                    ans[i] = ans[i - 1] ^ 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String seq = "(((()(())())))";
        char[] chars = seq.toCharArray();
        int[] ans = maxDepthAfterSplit(seq);

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
