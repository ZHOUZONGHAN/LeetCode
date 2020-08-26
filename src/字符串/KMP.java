package 字符串;

public class KMP {

    public static int kmp(String text, String pattern, int[] next) {
        for (int i = 0, j = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String pattern) {
        int[] next = new int [pattern.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                next[i] = ++j;
            }
        }
        pattern.substring(0,next[pattern.length()]);
        return next;
    }

    public static void main(String[] args) {
        String text = "abxabcabcaby";
        String pattern = "abcaby";
        int[] next = kmpNext(pattern);
        int start = kmp(text,pattern,next);
        System.out.println(start);
    }
}