package 剑指Offer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * for循环速度高于iter
 */
public class 数组中的重复数字 {

    public int findRepeatNumber2(int[] nums) {

        int[] nums2 = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums2[nums[i]] == 1) {
                return nums[i];
            }
            nums2[nums[i]] = 1;
        }

        return -1;
    }

    public int findRepeatNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }

        return -1;
    }

}
