package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 *
 * 提示：
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 */

/**
 * 可以不用设置isVisit，访问完直接讲该位置设为-1即可
 */
public class 水域大小 {

    List<Integer> list = new ArrayList<>();

    int size;

    public void dfs(int[][] land, int row, int column) {
        if (row < 0 || row > land.length - 1 || column < 0 || column > land[0].length - 1 || land[row][column] != 0) {
            return;
        }
        land[row][column] = -1;
        size++;
        dfs(land,row - 1,column - 1);
        dfs(land,row - 1,column);
        dfs(land,row - 1,column + 1);
        dfs(land,row,column - 1);
        dfs(land,row,column + 1);
        dfs(land,row + 1,column - 1);
        dfs(land,row + 1,column);
        dfs(land,row + 1,column + 1);
    }

    public int[] pondSizes(int[][] land) {

        int rows = land.length, columns = land[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (land[i][j] == 0) {
                    size = 0;
                    dfs(land,i,j);
                    list.add(size);
                }
            }
        }

        int[] ans = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            ans[i++] = integer;
        }
        Arrays.sort(ans);
        return ans;
    }
}
