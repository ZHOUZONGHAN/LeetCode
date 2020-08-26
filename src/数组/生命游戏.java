package 数组;

public class 生命游戏 {

    public static void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length + 2][board[0].length + 2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                temp[i + 1][j + 1] = board[i][j];
            }
        }
        for (int i = 1; i < board.length + 1; i++) {
            for (int j = 1; j < board[0].length + 1; j++) {
                if (temp[i - 1][j - 1] + temp[i - 1][j] + temp[i - 1][j + 1]  + temp[i][j - 1]+ temp[i][j + 1]  + temp[i + 1][j - 1] + temp[i + 1][j] + temp[i + 1][j + 1] < 2) {
                    board[i - 1][j - 1] = 0;
                    continue;
                }
                if (temp[i - 1][j - 1] + temp[i - 1][j] + temp[i - 1][j + 1]  + temp[i][j - 1]+ temp[i][j + 1]  + temp[i + 1][j - 1] + temp[i + 1][j] + temp[i + 1][j + 1] == 3) {
                    board[i - 1][j - 1] = 1;
                }
                if (board[i - 1][j - 1] == 1) {
                    if (temp[i - 1][j - 1] + temp[i - 1][j] + temp[i - 1][j + 1]  + temp[i][j - 1]+ temp[i][j + 1]  + temp[i + 1][j - 1] + temp[i + 1][j] + temp[i + 1][j + 1] > 3) {
                        board[i - 1][j - 1] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
