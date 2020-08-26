package 动态规划;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 */
public class 按摩师 {

    public static int massage(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {

            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums0 = {2,1,4,5,3,1,1,3};
        int[] nums1 = {};
        int[] nums2 = {2,1,1,2};
        int[] nums3 = {2,1,4};
        int[] nums4 = {1,3,1};
        System.out.println(massage(nums0));
        System.out.println(massage(nums1));
        System.out.println(massage(nums2));
        System.out.println(massage(nums3));
        System.out.println(massage(nums4));
    }
}
