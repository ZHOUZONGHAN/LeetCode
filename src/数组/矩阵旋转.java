package 数组;

public class 矩阵旋转 {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) {
                    continue;
                }
                matrix[i][j] = matrix[i][j] + matrix[j][i];
                matrix[j][i] = matrix[i][j] - matrix[j][i];
                matrix[i][j] = matrix[i][j] - matrix[j][i];

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][n - j - 1];
                matrix[i][n - j - 1] = matrix[i][j] - matrix[i][n - j - 1];
                matrix[i][j] = matrix[i][j] - matrix[i][n - j - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }
}
