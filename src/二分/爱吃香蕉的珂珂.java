package 二分;

/**
 * @author zhouzh6
 * @date 2020-10-23
 */
public class 爱吃香蕉的珂珂 {

    public static int minEatingSpeed(int[] piles, int H) {
        int left = 0, right = 0, sum = 0;
        for (int pile : piles) {
            sum += pile;
            right = Math.max(right, pile);
        }
        // 向上取整
        left = (sum + H - 1) / H;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (eat(mid, piles, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean eat(int mid, int[] piles, int h) {
        int count = 0;
        for (int pile : piles) {
            count += (pile + mid - 1) / mid;
            if (count > h) {
                return false;
            }
        }
        return true;
    }
}
