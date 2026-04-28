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

        // toss
        char playerSymbol = 'X';
        char computerSymbol = 'O';

        if (random.nextInt(2) == 1) {
            playerSymbol = 'O';
            computerSymbol = 'X';
        }

        System.out.println("\nPlayer: " + playerSymbol + "  Computer: " + computerSymbol);

        // GAME LOOP
        while (true) {

            // PLAYER MOVE
            System.out.print("\nEnter slot (1-9): ");
            int slot = input.nextInt();

            int row = getRow(slot);
            int col = getCol(slot);

            if (!isValidMove(board, row, col)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            placeMove(board, row, col, playerSymbol);
            printBoard(board);

            if (checkWinner(board, playerSymbol)) {
                System.out.println("Player wins!");
                break;
            }

            // COMPUTER MOVE
            computerMove(board, computerSymbol);
            printBoard(board);

            if (checkWinner(board, computerSymbol)) {
                System.out.println("Computer wins!");
                break;
            }

            // DRAW CHECK
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

    // slot to row
    public static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // slot to col
    public static int getCol(int slot) {
        return (slot - 1) % 3;
    }

    // validate move
    public static boolean isValidMove(char[][] board, int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        return board[row][col] == '-';
    }

    // place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // computer move
    public static void computerMove(char[][] board, char symbol) {

        Random random = new Random();
        int slot, row, col;

        while (true) {

            slot = random.nextInt(9) + 1;

            row = getRow(slot);
            col = getCol(slot);

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, symbol);
                System.out.println("\nComputer chose slot: " + slot);
                break;
            }
        }
    }

    // UC9: check winner
    public static boolean checkWinner(char[][] board, char symbol) {

        // rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        // columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol) {
                return true;
            }
        }

        // diagonal
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        // reverse diagonal
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