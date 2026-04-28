import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = new char[3][3];
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        System.out.println("Initial Board:");
        printBoard(board);

        char playerSymbol = 'X';
        char computerSymbol = 'O';

        // game loop
        while (true) {

            // player move
            System.out.print("\nEnter slot (1-9): ");
            int slot = input.nextInt();

            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '-') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[row][col] = playerSymbol;
            printBoard(board);

            if (checkWinner(board, playerSymbol)) {
                System.out.println("Player wins!");
                break;
            }

            // computer move
            int cRow, cCol;
            while (true) {
                int cSlot = random.nextInt(9) + 1;
                cRow = (cSlot - 1) / 3;
                cCol = (cSlot - 1) % 3;

                if (board[cRow][cCol] == '-') {
                    board[cRow][cCol] = computerSymbol;
                    System.out.println("\nComputer chose slot: " + cSlot);
                    break;
                }
            }

            printBoard(board);

            if (checkWinner(board, computerSymbol)) {
                System.out.println("Computer wins!");
                break;
            }

            if (isBoardFull(board)) {
                System.out.println("Game is a draw!");
                break;
            }
        }
    }

    // print board
    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // check winner
    public static boolean checkWinner(char[][] board, char symbol) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol) {
                return true;
            }
        }

        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    // check draw
    public static boolean isBoardFull(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}