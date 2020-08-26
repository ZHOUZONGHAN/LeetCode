package DFS_BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;

        if (len == 0) {
            return ans;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] isVisit = new boolean[len];

        dfs(nums,len,0,isVisit,path,ans);

        return ans;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] isVisit, Deque<Integer> path, List<List<Integer>> ans) {

        // 终止条件
        if (depth == len) {
            // 当depth == len 时，栈中存放的结果就是一种答案
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (isVisit[i]) {
                continue;
            }
            // xiu
            isVisit[i] = true;
            path.addLast(nums[i]);
            dfs(nums, len, depth + 1, isVisit, path, ans);
            isVisit[i] = false;
            path.removeLast();
        }

    }
}
