package 动态规划;

/**
 * @author zhouzh6
 * @date 2020-07-30
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * dp[i] = max {max (j × (i − j), j × dp[i − j])}
 *        1≤j<i
 */
public class 整数拆分 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }
}
