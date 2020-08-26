package 动态规划;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 */
public class 硬币 {

    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        // 一般多开一个位置，0 空着不用
        int[][] dp = new int[coins.length + 1][n + 1];
        // base case
        for (int i = 1; i <= 4; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                // 下面👇这部分代码是可以进一步改写的，因为从状态转移方程里面可以看到都有 dp[i-1][j],
                // 因此可以直接不用判断就赋值给 dp[i][j]，判断后再加上『 选择当前硬币时 』的补偿值就可以了
                // 要组成的面值比当前硬币金额小，该硬币不可以选择
                if (j - coins[i-1] < 0) {
                    // 只能由 i - 1 中硬币来组成面值 j
                    dp[i][j] = dp[i - 1][j] % 1000000007;
                } else {
                    // 当前硬币可以不选，也可以选择
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i-1]]) % 1000000007;
                }
            }
        }
        return dp[coins.length][n];
    }

}
