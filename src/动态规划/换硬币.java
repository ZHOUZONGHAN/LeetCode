package 动态规划;

/**
 * 给出不同面额的硬币以及一个总金额. 写一个方法来计算给出的总金额可以换取的最少的硬币数量.
 * 如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1.
 */
public class 换硬币 {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; ++j) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 7};
        int amount = 27;
        System.out.println(coinChange(coins, amount));
    }
}
