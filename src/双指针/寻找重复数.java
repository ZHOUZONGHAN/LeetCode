package 双指针;

/**
 * @author zhouzh6
 * @date 2020-10-21
 */
public class 寻找重复数 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,1,2}));
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }

        return pre1;
    }
}
