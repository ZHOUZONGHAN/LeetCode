package 图;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouzh6
 * @date 2020-09-25
 */
public class 课程表 {

    public static void main(String[] args) {
        System.out.println(canFinish(6, new int[][]{{0,1},{1, 2},{2, 3},{3,4},{5,4},{2,4}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            courses.get(prerequisite[0]).add(prerequisite[1]);
        }
        int[] flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(courses, flag, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> courses, int[] flag, int i) {
        if (flag[i] == -1) {
            return false;
        }
        if (flag[i] == 1) {
            return true;
        }
        flag[i] = 1;
        for (Integer j : courses.get(i)) {
            if (dfs(courses, flag, j)) {
                return true;
            }
        }
        flag[i] = -1;
        return false;
    }
}
