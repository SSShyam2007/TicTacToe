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

        // toss
        Random random = new Random();
        int toss = random.nextInt(2);

        char currentSymbol = (toss == 0) ? 'X' : 'O';
        System.out.println("\nGame starts with symbol: " + currentSymbol);

        // input
        int slot = getUserInput();

        int row = getRow(slot);
        int col = getCol(slot);

        // validation
        if (isValidMove(board, row, col)) {

            // UC6: place symbol
            placeMove(board, row, col, currentSymbol);

            System.out.println("\nUpdated Board:");
            printBoard(board);

        } else {
            System.out.println("Invalid move. Try again.");
        }
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

    // input
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

    // UC6: place symbol
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }
}