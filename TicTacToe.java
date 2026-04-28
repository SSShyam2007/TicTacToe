import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        System.out.println("Initial Board:");
        printBoard(board);

        // user move
        int slot = getUserInput();
        int row = getRow(slot);
        int col = getCol(slot);

        if (isValidMove(board, row, col)) {
            placeMove(board, row, col, 'X');
        }

        System.out.println("\nAfter Player Move:");
        printBoard(board);

        // UC7 → computer move
        computerMove(board);

        System.out.println("\nAfter Computer Move:");
        printBoard(board);
    }

    // print board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // user input
    public static int getUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter slot (1-9): ");
        return input.nextInt();
    }

    // mapping
    public static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    public static int getCol(int slot) {
        return (slot - 1) % 3;
    }

    // validation
    public static boolean isValidMove(char[][] board, int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    // place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: computer random move
    public static void computerMove(char[][] board) {

        Random random = new Random();
        int slot;
        int row, col;

        // loop until valid move
        while (true) {

            slot = random.nextInt(9) + 1; // 1 to 9

            row = getRow(slot);
            col = getCol(slot);

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, 'O');
                System.out.println("\nComputer chose slot: " + slot);
                break;
            }
        }
    }
}