package 动态规划;

/**
 * 给出一个非负整数数组，你最初定位在数组的第一个位置。　　　
 * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　
 * 判断你是否能到达数组的最后一个位置。
 */
public class 跳跃游戏 {

    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public static boolean canJump(int[] A) {
        // write your code here
        int len = A.length;
        boolean[] res = new boolean[len];
        res[0] = true;
        for (int j = 1; j < len; j++) {
            res[j] = false;
            for (int i = 0; i < j; i++) {
                if (res[i] && A[i] >= (j - i)) {
                    res[j] = true;
                }
            }
        }
        return res[len - 1];
    }

    public static void main(String[] args) {
        int[] A = {2,1,0,2,3,2,8,5,7,10,9,9,6,6,3,4,2,9,9,0};
        System.out.println(canJump(A));
    }
}
