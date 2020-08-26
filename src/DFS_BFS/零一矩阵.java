package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 零一矩阵 {

    public static int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int y = point[0];
            int x = point[1];
            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (newY >= 0 && newY < m && newX >= 0 && newX < n && matrix[newY][newX] == -1) {
                    matrix[newY][newX] = matrix[y][x] + 1;
                    queue.offer(new int[]{newY,newX});
                }
            }
        }
        return matrix;
    }

}
