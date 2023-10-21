import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return true;
        }
        return false;
    }

    private static void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();
        printBoard();
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your position (row and column):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
                System.out.println("Invalid move, try again.");
                continue;
            }
            board[row][col] = currentPlayer;
            printBoard();
            if (checkForWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a tie!");
                break;
            }
            changePlayer();
        }
        scanner.close();
    }
}
