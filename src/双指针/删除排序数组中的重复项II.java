package 双指针;

/**
 * @author zhouzh6
 * @date 2020-10-19
 */
public class 删除排序数组中的重复项II {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    public static int removeDuplicates2(int[] nums) {

        int j = 1, count = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static int removeDuplicates(int[] nums) {
        int i = 1, j = 1;
        int count = 1;
        while (j < nums.length) {
            if (nums[j] == nums[j - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
