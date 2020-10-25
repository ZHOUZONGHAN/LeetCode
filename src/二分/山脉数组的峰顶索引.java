package 二分;

/**
 * @author zhouzh6
 * @date 2020-10-23
 */
public class 山脉数组的峰顶索引 {

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
