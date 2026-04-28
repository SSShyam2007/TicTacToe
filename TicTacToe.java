import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        // create board
        char[][] board = new char[3][3];

        // initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // print board
        System.out.println("Initial Board:");
        printBoard(board);

        // toss
        Random random = new Random();
        int toss = random.nextInt(2);

        String currentPlayer;
        char player1Symbol;
        char player2Symbol;

        if (toss == 0) {
            currentPlayer = "Player 1";
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = "Player 2";
            player1Symbol = 'O';
            player2Symbol = 'X';
        }

        System.out.println("\n" + currentPlayer + " starts first");

        // UC3 → take input
        int slot = getUserInput();

        System.out.println("You selected slot: " + slot);
    }

    // method to print board
    public static void printBoard(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC3 method → user input
    public static int getUserInput() {

        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter slot number (1-9): ");

        int slot = input.nextInt();

        return slot;
    }
}