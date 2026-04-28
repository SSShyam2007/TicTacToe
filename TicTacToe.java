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

        String currentPlayer = (toss == 0) ? "Player 1" : "Player 2";
        System.out.println("\n" + currentPlayer + " starts first");

        // UC3 input
        int slot = getUserInput();

        // UC4 mapping
        int row = getRow(slot);
        int col = getCol(slot);

        System.out.println("Row: " + row + ", Column: " + col);
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

    // convert slot → row
    public static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // convert slot → column
    public static int getCol(int slot) {
        return (slot - 1) % 3;
    }
}