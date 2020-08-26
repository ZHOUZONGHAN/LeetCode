package 排序;

import java.util.Arrays;

public class 合并区间 {

    public static int[][] merge(int[][] intervals) {
        /**
         * Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
         * 假设传来两个值，v1 与 v2，那么他们的先后顺序以 v1[0] 比 v2[0] 的结果为准，
         * 即：若 v1[0] < v2[0] 则 v1 < v2
         *
         * 举一反三：Arrays.sort(intervals, (v1, v2) -> v1[0] == v2[0] ? v2[1] - v1[1] : v1[0] - v2[0]);
         * 表示：传来两个值 v1 与 v2，若 [0] 相同，则按 [1] 降序；若不同则按 [0] 升序。
         */
        Arrays.sort(intervals,(v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];

        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || res[index][1] < interval[0]) {
                res[++index] = interval;
            } else {
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }

        return Arrays.copyOf(res, index + 1);
    }
}
