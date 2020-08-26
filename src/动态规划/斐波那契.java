package 动态规划;

import java.util.Scanner;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class 斐波那契 {

    public static int Fibonacci(int n) {
        int temp1 = 0, temp2 = 1;
        while (n-- > 0) {
            temp2 = temp1 + temp2;
            temp1 = temp2 - temp1;
        }
        return temp1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Fibonacci(n));
    }
}
