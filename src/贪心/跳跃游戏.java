package 贪心;

public class 跳跃游戏 {

    public static boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxJump) {
                maxJump = Math.max(maxJump, i + nums[i]);
                if (maxJump >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
