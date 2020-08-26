package 双指针;

public class 优美子数组 {

    public static int numberOfSubarrays1(int[] nums, int k) {
        int ans = 0;
        int left = 0, right = 0, count = 0;
        while (right < nums.length) {
            int leftEven = 0, rightEven = 0;
            if ((nums[right++] & 1) == 1) {
                count++;
            }
            if (count == k) {
                while ((nums[left] & 1) == 0) {
                    ++leftEven;
                    ++left;
                }
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                    ++rightEven;
                }
                ans += (leftEven + 1) * (rightEven + 1);
                ++left;
                --count;
            }
        }
        return ans;
    }


}
