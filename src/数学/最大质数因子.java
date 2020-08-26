package 数学;

import java.util.Scanner;

public class 最大质数因子 {
    public static boolean checkPrime(double num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void maxPrime() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double num = scanner.nextInt();
            // 判断输入的数是否为质数
            if (checkPrime(num)) {
                System.out.println((int)num);
            }
            for (int i = (int) (num / 2) + 1; i > 1; --i) {
                // 判断因子是否为质数
                if (num % i == 0 && checkPrime(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
