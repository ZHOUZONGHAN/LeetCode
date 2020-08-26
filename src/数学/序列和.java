package 数学;

import java.util.Scanner;

public class 序列和 {
    /**
     * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，需要找出长度最小的那个。
     * 例如 N = 18 L = 2：
     * 5 + 6 + 7 = 18
     * 3 + 4 + 5 + 6 = 18
     * 都是满足要求的，但是我们输出更短的 5 6 7
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();


        for(int i = L; i <= 100; i++) {
            if((2*N+i-i*i)%(2*i) == 0) {
                int start = (2*N+i-i*i)/(2*i);
                for(int j = 0; j < i-1; j++) {
                    System.out.print(start + j + " ");
                }
                System.out.print(start + i - 1);
                break;
            }
            if (i == 100) {

                System.out.println("No");
            }
        }

    }
}
