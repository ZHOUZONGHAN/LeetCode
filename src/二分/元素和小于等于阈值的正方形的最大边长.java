package 二分;

/**
 * @author zhouzh6
 * @date 2020-10-23
 */
public class 元素和小于等于阈值的正方形的最大边长 {

    public static int maxSideLength(int[][] mat, int threshold) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        // 前缀和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n);
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (check(mid, dp, threshold)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (check(right, dp, threshold)) {
            return right;
        } else {
            return left;
        }
    }

    private static boolean check(int mid, int[][] dp, int threshold) {
        for (int i = mid; i < dp.length; i++) {
            for (int j = mid; j < dp[0].length; j++) {
                if (dp[i][j] - dp[i - mid][j] - dp[i][j - mid] + dp[i - mid][j - mid] <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
