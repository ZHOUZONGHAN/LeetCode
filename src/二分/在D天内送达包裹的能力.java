package 二分;

/**
 * @author zhouzh6
 * @date 2020-10-23
 */

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * <p>
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * <p>
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 */
public class 在D天内送达包裹的能力 {

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    public static int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int left = 0;
        for (int weight : weights) {
            sum += weight;
            left = Math.max(left, weight);
        }
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int days = find(mid, weights);
            if (days > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int find(int mid, int[] weights) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > mid) {
                sum = weights[i];
                count++;
            } else {
                sum += weights[i];
            }
        }
        return count;
    }
}
