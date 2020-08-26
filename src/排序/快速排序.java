package 排序;

public class 快速排序 {

    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int left = L;
        int right = R;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && pivot <= arr[right]) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && pivot >= arr[left]) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left >= right) {
                arr[left] = pivot;
            }
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,4,4,3,5,8,9,5,1,2,3};
        quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
