package 双指针;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 *
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 */
public class 验证回文字符串II {
    public boolean validPalindrome(String s) {
        boolean ans = true;

        int low = 0, high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = low + 1, j = high; i <= j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low, j = high - 1; i <= j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }

        }

        return ans;
    }
}
