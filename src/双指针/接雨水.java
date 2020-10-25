package 双指针;

public class 接雨水 {

    public static void main(String[] args) {
        System.out.println(trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap3(int[] height) {
        int res = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }

    /**
     * 一层层判断，判断后，将非0数字的全部-1
     * 当一层中非0数字小于2时则break
     * 计算一层时，设置一个start和一个end，第一个非0数字的下标为start，下一个非0数字为end，end - start - 1为start与end之间的雨水量
     * 计算完后将start = end，在找下一个不为0的数字获取下标
     */
    public static int trap(int[] height) {
        int res = 0;
        int start = 0, end = 0;
        do {
            start = 0; end = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] != 0) {
                    if (height[start] == 0) {
                        start = i;
                    } else {
                        end = i;
                    }
                    if (end > start) {
                        res += end - start - 1;
                        start = end;
                    }
                }
            }
            for (int i = 0; i < height.length; i++) {
                if (height[i] != 0) {
                    height[i]--;
                }
            }
        } while (end != 0);
        return res;
    }

    public static int trap2(int[] height) {
        int res = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            if (leftMax < rightMax) {
                if (leftMax > height[left]) {
                    res += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    res += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return res;
    }
}
