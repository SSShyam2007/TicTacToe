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

 dev
        // USER MOVE

        // toss
        Random random = new Random();
        int toss = random.nextInt(2);

        char currentSymbol = (toss == 0) ? 'X' : 'O';
        System.out.println("\nGame starts with symbol: " + currentSymbol);

        // input
 feature/UC1-display-board
        int slot = getUserInput();
        int row = getRow(slot);
        int col = getCol(slot);

 dev
        if (isValidMove(board, row, col)) {
            placeMove(board, row, col, 'X');

        // validation
        if (isValidMove(board, row, col)) {

            // UC6: place symbol
            placeMove(board, row, col, currentSymbol);

            System.out.println("\nUpdated Board:");
            printBoard(board);

          feature/UC1-display-board
        } else {
            System.out.println("Invalid move");
            return;
        }

        System.out.println("\nAfter Player Move:");
        printBoard(board);

        // COMPUTER MOVE (UC7)
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

    // slot → row
    public static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // slot → column
    public static int getCol(int slot) {
        return (slot - 1) % 3;
    }

 dev
    // validate move

    // validation
 feature/UC1-display-board
    public static boolean isValidMove(char[][] board, int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

dev
    // place symbol
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: computer random move
    public static void computerMove(char[][] board) {

        Random random = new Random();
        int slot, row, col;

        while (true) {

            slot = random.nextInt(9) + 1;

            row = getRow(slot);
            col = getCol(slot);

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, 'O');
                System.out.println("\nComputer chose slot: " + slot);
                break;
            }
        }
    }

    // UC6: place symbol
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }
 feature/UC1-display-board
}