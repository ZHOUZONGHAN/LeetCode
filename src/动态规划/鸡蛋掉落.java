package 动态规划;

import java.util.Arrays;

public class 鸡蛋掉落 {

    public static int superEggDrop3(int egg, int floor) {
        if (floor == 1) {
            return 1;
        }
        int[][] f = new int[floor + 1][egg + 1];
        for (int i = 1; i <= egg; ++i) {
            f[1][i] = 1;
        }
        int ans = -1;
        for (int i = 2; i <= floor; ++i) {
            for (int j = 1; j <= egg; ++j) {
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][egg] >= floor) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static int superEggDrop2(int egg, int floor) {
        // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少仍的次数
        int[][] dp = new int[floor + 1][egg + 1];

        // 初始化
        for (int i = 0; i <= floor; i++) {
            Arrays.fill(dp[i], i);
        }
        for (int j = 0; j <= egg; j++) {
            dp[0][j] = 0;
        }

        dp[1][0] = 0;
        for (int j = 1; j <= egg; j++) {
            dp[1][j] = 1;
        }
        for (int i = 0; i <= floor; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        // 开始递推
        for (int i = 2; i <= floor; i++) {
            for (int j = 2; j <= egg; j++) {
                // 在区间 [1, i] 里确定一个最优值
                int left = 1;
                int right = i;
                while (left < right) {
                    // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                    int mid = left + (right - left + 1) / 2;

                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }
        return dp[floor][egg];
    }

    public static int superEggDrop(int egg, int floor) {
        // 定义状态
        int[][] dp = new int[floor + 1][egg + 1];

        // 初始化状态
        // 因为求最小值，所以初始化一个较大值
        for (int i = 0; i <= floor; i++) {
            Arrays.fill(dp[i],9999);
        }
        // 楼层为0或1
        for (int i = 0; i <= egg; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        // 蛋为0或1
        for (int i = 0; i <= floor; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        // 状态转移方程
        // 鸡蛋没碎 dp[floor - 当前楼层][egg]
        // 鸡蛋碎了 dp[floor - 1][egg - 1]
        for (int i = 2; i <= floor; i++) {
            for (int j = 2; j <= egg; j++) {
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[i - k][j],dp[k - 1][j - 1]) + 1);
                }
            }
        }


        return dp[floor][egg];
    }

}
