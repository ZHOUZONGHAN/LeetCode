package 数组;

public class 盛最多水的容器 {

    public static int maxArea(int[] height) {
        int max = 0;

        int leftMax = height[0], rightMax = height[height.length - 1];
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (leftMax < rightMax) {
                max = Math.max(max,leftMax * (right - left));
                do {
                    left++;
                } while (height[left] < leftMax);
                leftMax = height[left];
            } else {
                max = Math.max(max,rightMax * (right - left));
                do {
                    right--;
                } while (height[right] < rightMax);
                rightMax = height[right];
            }
        }
        return max;
    }
}
