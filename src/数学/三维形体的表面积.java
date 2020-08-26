package 数学;

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 */
public class 三维形体的表面积 {

    public static int surfaceArea(int[][] grid) {
        int cubes = 0;
        int faces = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                cubes += grid[i][j];
                if (grid[i][j] > 0) {
                    faces += grid[i][j] - 1;
                }
                if (i > 0 && grid[i-1][j] > 0) {
                    faces += Math.min(grid[i-1][j],grid[i][j]);
                }
                if (j > 0 && grid[i][j-1] > 0) {
                    faces += Math.min(grid[i][j-1],grid[i][j]);
                }
            }
        }
        return 6 * cubes - 2 * faces;
    }
    
    public static void main(String[] args) {
        System.out.println(surfaceArea(new int[][]{{2,2,2},{2,1,2},{2,2,2}}));
    }
}
