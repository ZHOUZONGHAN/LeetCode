package 二分;

/**
 * @author zhouzh6
 * @date 2020-10-21
 */

/**
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 */
public class 分割数组的最大值 {

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public static int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int split = split(nums, mid);
            if (split > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int split(int[] nums, int mid) {
        int splitNum = 1;
        int splitSum = 0;
        for (int num : nums) {
            if (splitSum + num > mid) {
                splitNum++;
                splitSum = 0;
            }
            splitSum += num;
        }
        return splitNum;
    }
}
