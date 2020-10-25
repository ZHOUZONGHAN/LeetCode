package 二分;

/**
 * @author zhouzh6
 * @date 2020-10-21
 */
public class 寻找重复数 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,2,2}));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1, right = n - 1;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
