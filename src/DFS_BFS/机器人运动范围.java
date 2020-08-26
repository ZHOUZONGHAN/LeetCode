package DFS_BFS;

public class 机器人运动范围 {
    int m, n, k;
    boolean[][] flag;

    public int digitalSum(int n) {
        int sum = 0;
        if (n >= 10) {
            while (n / 10 > 0) {
                sum += n % 10;
                n = n / 10;
            }
            sum += n;
        } else {
            sum += n;
        }
        return sum;
    }

    public int dfs(int i, int j) {
        if (i >= m || j >= n || digitalSum(i) + digitalSum(j) > k || flag[i][j]) {
            return 0;
        }
        flag[i][j] = true;
        return 1 + dfs(i, j + 1) + dfs(i + 1, j);
    }

    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        int res = 0;
        flag = new boolean[m][n];
        return dfs(0, 0);
    }
}
