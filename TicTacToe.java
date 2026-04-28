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

        // toss
        char currentSymbol = (random.nextInt(2) == 0) ? 'X' : 'O';

        boolean gameOver = false;

        System.out.println("Game Start");
        printBoard(board);

        // UC8 loop
        while (!gameOver) {

            if (currentSymbol == 'X') {

                // USER MOVE
                System.out.print("\nEnter slot (1-9): ");
                int slot = input.nextInt();

                int row = getRow(slot);
                int col = getCol(slot);

                if (!isValidMove(board, row, col)) {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }

                placeMove(board, row, col, 'X');

            } else {

                // COMPUTER MOVE
                computerMove(board);
            }

            printBoard(board);

            // check win
            if (checkWin(board, currentSymbol)) {
                System.out.println("\nPlayer " + currentSymbol + " wins!");
                gameOver = true;
                break;
            }

            // check draw
            if (isBoardFull(board)) {
                System.out.println("\nGame Draw!");
                gameOver = true;
                break;
            }

            // switch turn
            currentSymbol = (currentSymbol == 'X') ? 'O' : 'X';
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

    // mapping
    public static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    public static int getCol(int slot) {
        return (slot - 1) % 3;
    }

    // validation
    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    // place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // computer move
    public static void computerMove(char[][] board) {

        Random random = new Random();

        while (true) {
            int slot = random.nextInt(9) + 1;

            int row = getRow(slot);
            int col = getCol(slot);

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, 'O');
                System.out.println("\nComputer chose: " + slot);
                break;
            }
        }
    }

    // check win
    public static boolean checkWin(char[][] board, char symbol) {

        // rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;

            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }

        // diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

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