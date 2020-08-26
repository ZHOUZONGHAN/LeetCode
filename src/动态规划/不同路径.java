package 动态规划;

import java.util.Stack;

/**
 * 有一个机器人的位于一个 m × n 个网格左上角。
 * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * 问有多少条不同的路径？
 */
public class 不同路径 {

    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public static int uniquePaths(int m, int n) {
        // write your code here
        int[][] path = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    path[i][j] = 1;
                    continue;
                }
                path[i][j] = path[i][j-1] + path[i-1][j];
            }
        }
        return path[m-1][n-1];

    }


    public static void main(String[] args) {
//        System.out.println(Math.abs(-5));
//        System.out.println(uniquePaths(1,3));

        Stack<Integer> stack = new Stack<>();
        int j = 2;
        stack.push(1);
        int i = 0;
        while(j < 10) {
            stack.push(j);
            j++;
            ++i;
        }
        System.out.println(stack.pop());
        while(i != 0) {
            System.out.println(stack.pop());
            --i;
        }
    }
}
