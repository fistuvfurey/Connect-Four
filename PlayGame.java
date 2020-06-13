package com.connectfour;
import java.util.Scanner;
public class PlayGame {

    public static void main(String[] args) {
        Board board = new Board();
        Player redPlayer = new Player('R');
        Player yellowPlayer = new Player('Y');

        Scanner stdin = new Scanner(System.in);

        // redPlayer goes first
        redPlayer.setIsTurn(true);
        // loops until a player wins or there is a draw (which takes 42 turns)
        int turnCount = 0;
        while (turnCount < 42) {
            // display board
            board.displayBoard();

            // determine whose turn it is and reference that player using a new Player object called currentPlayer
            Player currentPlayer = redPlayer.determineTurn(yellowPlayer);

            // save the currentPlayer color into a new String variable for display purposes
            String currentPlayerColor;
            if (currentPlayer.getPlayerColor() == 'R')
                currentPlayerColor = "Red";
            else
                currentPlayerColor = "Yellow";
            System.out.println(currentPlayerColor + " player, it is your turn.");
            System.out.print("Enter the column number you want to drop a " + currentPlayerColor.toLowerCase()
                    + " disk in (0 - 6): ");

            // drop a chip into the board
            int column = 0;
            // this loops make sure that the user is entering an int
            while (!stdin.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                stdin.next();
            }
            column = stdin.nextInt();
            // this loop makes sure the int is 0-6
            while (true) {
                if (column >= 0 && column <= 6)
                    break;
                else {
                    System.out.print("Invalid number! Please enter a column number (0 - 6): ");
                    // make sure new input is an int
                    while (!stdin.hasNextInt()) {
                        System.out.print("Invalid input. Please enter a number: ");
                        stdin.next();
                    }
                    column = stdin.nextInt();
                }
            }
            // check to see if the selected column is full
            while (true) {
                if (board.checkIfColumnFull(column)) {
                    System.out.print("Column full! Please enter a different column number: ");
                    // make sure that the new input is an int
                    while (!stdin.hasNextInt()) {
                        System.out.print("Invalid input. Please enter a number: ");
                        stdin.next();
                    }
                    column = stdin.nextInt();
                    // validate new user input again
                    while (true) {
                        if (column >= 0 && column <= 6)
                            break;
                        else {
                            System.out.print("Invalid number! Please enter a column number (0 - 6): ");
                            // make sure that the new input is an int
                            while (!stdin.hasNextInt()) {
                                System.out.print("Invalid input. Please enter a number: ");
                                stdin.next();
                            }
                            column = stdin.nextInt();
                        }
                    }
                }
                else {
                    board.setBoard(currentPlayer, column);
                    break;
                }
            }

            // check to see if the currentPlayer has won
            board.checkFourInADiagonal(currentPlayer);
            board.checkFourInAColumn(currentPlayer);
            board.checkFourInARow(currentPlayer);
            if (currentPlayer.getHasWon())
                break;

            // change turns and update turnCount
            redPlayer.changeTurns(yellowPlayer);
            turnCount++;
        }
        stdin.close();

        // display final results
        board.displayBoard();
        if (redPlayer.getHasWon()) System.out.println("The Red player has won!");
        else if (yellowPlayer.getHasWon()) System.out.println("The Yellow player has won!");
        else System.out.println("There is a draw!");
    }
}
