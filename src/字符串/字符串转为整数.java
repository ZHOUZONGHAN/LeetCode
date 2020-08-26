package 字符串;

public class 字符串转为整数 {

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.equals("")) {
            return 0;
        }
        String max_value = "2147483647";
        char[] maxs = max_value.toCharArray();
        char[] chars = str.toCharArray();
        boolean flag = false;
        boolean flag2 = true;
        StringBuilder stringBuilder = new StringBuilder();
        int j = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            // 第一个字符不为符号或数字
            if (i == 0 && chars[0] != '+' && chars[0] != '-' && chars[0] < '0' && chars[0] > '9') {
                return 0;
            }
            // 第一个字符为+-号
            if (i == 0 && (chars[0] == '+' || chars[0] == '-')) {
                continue;
            }
            // 某一个字符非数字
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }
            if (chars[i] == '0' && stringBuilder.length() == 0) {
                continue;
            }
            // 字符为数字
            if (chars[i] >= '0' && chars[i] <= '9') {
                stringBuilder.append(chars[i]);
                ++j;
            }
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            char[] nums = stringBuilder.toString().toCharArray();
            if (stringBuilder.length() > 10) {
                res = 2147483647;
                flag = true;
                break;
            }
            if (flag2 && stringBuilder.length() == 10) {
                if (nums[i] > maxs[i]) {
                    res = 2147483647;
                    flag = true;
                    break;
                }
                if (nums[i] != maxs[i]) {
                    flag2 = false;
                }
            }
            if (nums[i] >= '0' && nums[i] <= '9') {
                res += Integer.parseInt(nums[i] + "");
                if (i != nums.length - 1) {
                    res *= 10;
                }

            } else {
                break;
            }
        }
        if (chars[0] == '-') {
            res = res * -1;
            if (flag && res == Integer.MIN_VALUE + 1) {
                res = res - 1;
            }
        }
        return res;
    }

    public static int myAtoi2(String str) {
        str = str.trim();
        if (str.equals("")) {
            return 0;
        }
        int res = 0;
        char[] chars = str.toCharArray();
        // 下标值
        int i = 0;
        // 正负号标记
        boolean flag = true;
        if (chars[i] == '+') {
            i++;
        } else if (chars[i] == '-') {
            flag = false;
            i++;
        } else if (!Character.isDigit(chars[i])) {
            return 0;
        }
        while (i < chars.length && Character.isDigit(chars[i])) {
            int temp = chars[i] - '0';
            if (res > (Integer.MAX_VALUE - temp) / 10) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + temp;
            i++;
        }
        return flag ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi2(""));
    }
}
