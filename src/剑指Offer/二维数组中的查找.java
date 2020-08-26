package 剑指Offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class 二维数组中的查找 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length, columns = matrix[0].length;

        if (target > matrix[rows - 1][columns - 1] || target < matrix[0][0]) {
            return false;
        }

        int row = 0, column = columns - 1;
        while (row <= rows - 1 && column >= 0) {
            int num = matrix[row][column];
            if (target == num) {
                return true;
            }
            if (num > target) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }
}
