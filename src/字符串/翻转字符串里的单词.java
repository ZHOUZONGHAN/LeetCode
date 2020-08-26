package 字符串;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 翻转字符串里的单词 {

    public static String reverseWords3(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals("")) {
                continue;
            }
            sb.append(arr[i]).append(" ");
        }
        s = sb.toString();
        if (s.equals("")) {
            return s;
        }
        return s.substring(0, s.length() - 1);
    }

    public static String reverseWords2(String s) {
        s = s.trim();
        String[] split = s.split("\\s+");
        List<String> list = Arrays.asList(split);
        Collections.reverse(list);
        String ans = String.join(" ", list);
        return ans;
    }

    public static String reverseWords(String s) {
        String ans = "";
        s = s.trim();
        String[] strings = s.split(" ");
        int len = strings.length;
        while (len > 0) {
            if (strings[len - 1].equals("")) {
                len--;
                continue;
            }
            ans += strings[len - 1] + " ";
            len--;
        }
        ans = ans.trim();

        return ans;
    }
}
