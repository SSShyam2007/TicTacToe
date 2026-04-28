import java.util.Random;

public class TicTacToe {

    public static void main(String[] args) {

        // board
        char[][] board = new char[3][3];

        // initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // print board
        System.out.println("Initial Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        // random toss
        Random random = new Random();
        int toss = random.nextInt(2); // 0 or 1

        String currentPlayer;
        char player1Symbol;
        char player2Symbol;

        // conditional logic
        if (toss == 0) {
            currentPlayer = "Player 1";
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = "Player 2";
            player1Symbol = 'O';
            player2Symbol = 'X';
        }

        // display result
        System.out.println("\nToss Result:");
        System.out.println(currentPlayer + " starts first");
        System.out.println("Player 1 symbol: " + player1Symbol);
        System.out.println("Player 2 symbol: " + player2Symbol);
    }
}