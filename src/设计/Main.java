package 设计;

import java.util.Scanner;

public class Main {

    // 资源个数
    public static int M;
    // 线程个数
    public static int N;
    public static int[][] Allocation;
    public static int[][] Need;
    public static int[] Available;
    public static int[] Work;
    public static boolean[] Finish;

    public Main() {
    }

    public Main(int n, int m) {
        N = n;
        M = m;
        Allocation = new int[M][N];
        Need = new int[M][N];
        Available = new int[M];
        Work = new int[M];
        Finish = new boolean[N];
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Main banker = new Main(n, m);
            banker.init();
            banker.safe();
        }
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Allocation[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Need[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            Available[i] = scanner.nextInt();
        }
    }

    public void safe() {

        for (int i = 0; i < M; i++) {
            Work[i] = Available[i];
        }

        int j, flag = 0;
        for (int i = 0; i < N; i++) {
            if (Finish[i]) {
                continue;
            } else {
                for (j = 0; j < M; j++) {
                    if (Need[j][i] > Work[j]) {
                        break;
                    }
                }
                if (j == M) {
                    Finish[i] = true;
                    for (int k = 0; k < M; k++) {
                        Work[k] += Allocation[k][i];
                    }
                    ++flag;
                    i = -1;
                } else {
                    continue;
                }
            }
        }
        if (flag == N) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}