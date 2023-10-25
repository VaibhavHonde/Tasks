import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static char[][] board = new char[ROWS][COLUMNS];
    private static char currentPlayer = 'R';

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }

    private static boolean dropPiece(int column) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    private static boolean checkForWin() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == currentPlayer && board[i][j + 1] == currentPlayer
                        && board[i][j + 2] == currentPlayer && board[i][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == currentPlayer && board[i + 1][j] == currentPlayer
                        && board[i + 2][j] == currentPlayer && board[i + 3][j] == currentPlayer) {
                    return true;
                }
            }
        }
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == currentPlayer && board[i + 1][j + 1] == currentPlayer
                        && board[i + 2][j + 2] == currentPlayer && board[i + 3][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == currentPlayer && board[i - 1][j + 1] == currentPlayer
                        && board[i - 2][j + 2] == currentPlayer && board[i - 3][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void changePlayer() {
        if (currentPlayer == 'R') {
            currentPlayer = 'Y';
        } else {
            currentPlayer = 'R';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();
        printBoard();
        while (true) {
            System.out.println("Player " + currentPlayer + ", choose a column (1-7):");
            int column = scanner.nextInt();
            if (column < 1 || column > 7) {
                System.out.println("Invalid column, try again.");
                continue;
            }
            if (!dropPiece(column - 1)) {
                System.out.println("Column is full, try again.");
                continue;
            }
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
