package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {

    int ans = 0;

    char[][] gridTemp;

    boolean[][] isVisit;

    public void bfs(int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        int[] loc = new int[]{m,n};
        queue.offer(loc);
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0], y = temp[1];
            if (x - 1 >= 0 && !isVisit[x - 1][y] && gridTemp[x][y + 1] == '1') {
                queue.offer(new int[]{x - 1,y});
                isVisit[x - 1][y] = true;
            }
            if (x + 1 < gridTemp.length - 2 && !isVisit[x + 1][y] && gridTemp[x + 2][y + 1] == '1') {
                queue.offer(new int[]{x + 1,y});
                isVisit[x + 1][y] = true;
            }
            if (y - 1 >= 0 && !isVisit[x][y - 1] && gridTemp[x + 1][y] == '1') {
                queue.offer(new int[]{x,y - 1});
                isVisit[x][y - 1] = true;
            }
            if (y + 1 < gridTemp[0].length - 2 && !isVisit[x][y + 1] && gridTemp[x + 1][y + 2] == '1') {
                queue.offer(new int[]{x,y + 1});
                isVisit[x][y + 1] = true;
            }
        }
        ans += 1;
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        gridTemp = new char[m + 2][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gridTemp[i + 1][j + 1] = grid[i][j];
            }
        }

        isVisit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gridTemp[i + 1][j + 1] == '0') {
                    // 当访问到的是水
                    isVisit[i][j] = true;
                } else {
                    if (gridTemp[i + 1][j + 1] == '1' && !isVisit[i][j]) {
                        // 当访问到的是陆地  并且没有被访问过
                        bfs(i,j);
                    }
                }
            }
        }

        return ans;
    }

}
