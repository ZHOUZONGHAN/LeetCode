package 查找; /**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
import java.util.ArrayList;
public class 旋转数组的最小数字 {

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int left = 0, right = array.length - 1;
        int mid = left;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[left] < array[mid]) {
                left = mid;
            } else if (array[left] > array[mid]){
                right = mid;
            } else {
                left++;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        int[] array1 = {3,4,5,6,7,1,2};
        int[] array2 = {6,7,1,2,3,4,5};
        int[] array3 = {3,3,3,3,1,3,3};
        int[] array4 = {1};
        System.out.println(minNumberInRotateArray(array1));
        System.out.println(minNumberInRotateArray(array2));
        System.out.println(minNumberInRotateArray(array3));
        System.out.println(minNumberInRotateArray(array4));
    }
}
