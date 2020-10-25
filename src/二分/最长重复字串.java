package 二分;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouzh6
 * @date 2020-10-22
 */
public class 最长重复字串 {

    public static String longestDupSubstring(String str) {
        int len = str.length();
        int[] nums = new int[len];
        int param = 26;
        long modulus = (long) Math.pow(2, 32);

        for (int i = 0; i < len; i++) {
            nums[i] = str.charAt(i) - 'a';
        }

        int left = 1, right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (find(mid, nums, param, modulus, len) != -1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = find(left - 1, nums, param, modulus, len);

        if (start == -1) {
            return "";
        } else {
            return str.substring(start, start + left - 1);
        }
    }

    private static int find(int mid, int[] nums, int param, long modulus, int len) {
        Set<Long> seen = new HashSet<>();
        long h = 0;

        for (int i = 0; i < mid; i++) {
            h = (h * param + nums[i]) % modulus;
        }
        seen.add(h);

        long paramPower = 1;
        for (int i = 0; i < mid; i++) {
            paramPower = (paramPower * param) % modulus;
        }

        for (int i = 1; i <= len - mid; i++) {
            h = ((h * param) % modulus - (nums[i - 1] * paramPower) % modulus) % modulus;
            h = (h + nums[i + mid - 1]) % modulus;
            if (seen.contains(h)) {
                return i;
            }
            seen.add(h);
        }

        return -1;
    }

    public static String longestDupSubstring2(String str) {
        int len = str.length();
        int[] nums = new int[len];
        for (int i = 0; i < len; ++i) {
            nums[i] = (int) str.charAt(i) - (int) 'a';
        }
        // 系数
        int param = 26;
        // 取模值
        long modulus = (long) Math.pow(2, 32);

        int left = 1, right = len;
        int mid;
        while (left != right) {
            mid = left + (right - left) / 2;
            if (search(mid, param, modulus, len, nums) != -1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = search(left - 1, param, modulus, len, nums);
        return start != -1 ? str.substring(start, start + left - 1) : "";
    }

    /**
     *
     * @param mid 需要匹配的长度mid
     * @param param 系数26 幂
     * @param modulus 取模Math.pow(2, 32);
     * @param len 字符串长度
     * @param nums 数组
     * @return
     */
    public static int search(int mid, int param, long modulus, int len, int[] nums) {
        long h = 0;
        for (int i = 0; i < mid; ++i) {
            h = (h * param + nums[i]) % modulus;
        }

        Set<Long> seen = new HashSet();
        seen.add(h);

        // param的幂值
        long paramPower = 1;
        for (int i = 1; i <= mid; ++i) {
            paramPower = (paramPower * param) % modulus;
        }

        for (int start = 1; start < len - mid + 1; ++start) {
            h = ((h * param) - (nums[start - 1] * paramPower % modulus) + modulus) % modulus;
            h = (h + nums[start + mid - 1]) % modulus;
            if (seen.contains(h)) {
                return start;
            }
            seen.add(h);
        }
        return -1;
    }
}
