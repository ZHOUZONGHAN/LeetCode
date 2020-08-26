package 位运算;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */
public class 数组中数字出现的次数 {

    public int[] singleNumbers(int[] nums) {
        int ans = 0;
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        int flag = sum & (-sum);

        for (int num : nums) {
            if ((flag & num) == 0) {
                ans ^= num;
            }
        }
        return new int[]{ans, ans ^ sum};
    }
}
