package DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {

    List<String> list = new ArrayList<>();

    /**
     * 每次调用使用的 left 和 right 不同，所以需要放在方法参数中
     * 必须使用 left - 1 不能使用 left-- 和 --left，因为‘--’会导致left的值改变
     */
    public void dfs(int left, int right, String str) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, str + "(");
        }
        if (right > left) {
            dfs(left, right - 1, str + ")");
        }

    }

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        for (String s : list) {
            System.out.println(s);
        }
        return list;
    }
}
