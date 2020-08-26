package 双指针;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int ans = 0;
        HashMap<Character,Integer> charMap = new HashMap<>();
        int start = 0, end = 0;

        while (end != s.length()) {
            if (charMap.containsKey(s.charAt(end))) {
                /**
                 * 注意这里不能写为 start = charMap.get(s.charAt(end)) + 1;
                 * 因为 start 可能比 end + 1 大
                 */
                start = Math.max(start,charMap.get(s.charAt(end)) + 1);
            }
            charMap.put(s.charAt(end),end);
            ans = Math.max(ans,end - start + 1);
            end++;
        }
        return ans;
    }
}
