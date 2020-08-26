package util;

/**
 * @author zhouzh6
 * @date 2020-07-23
 */
public class ArrayUtils {

    public static void print(int[] arr) {
        for (int anInt : arr) {
            System.out.print(anInt + "    ");
        }
    }

    public static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "    ");
            }
            System.out.println();
        }
    }
}
