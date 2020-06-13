package com.connectfour;

public class Board {
    private char[][] board = new char[6][7];

    // construct an empty board
    public Board() {
        for (int row = 0; row < board.length; row++)
            for (int column = 0; column < board[row].length; column++)
                board[row][column] = '\0';
    }

    // drop a chip in desired column
    public void setBoard(Player player, int column) {
        int row = board.length - 1;
        for (int i = row; i > 0; i--) {
            if (board[row][column] != '\0') {
                row--;
                if (row == 0) {
                    board[row][column] = player.getPlayerColor();
                    break;
                }
            } else {
                board[row][column] = player.getPlayerColor();
                break;
            }
        }
    }

    public boolean checkIfColumnFull(int column) {
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            if (board[row][column] != '\0')
                count++;
        }
        return (count == board.length);
    }

    public void displayBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++)
                System.out.print(board[row][column] + " ");
            System.out.println();
        }
        for (int i = 0; i < 14; i++) System.out.print("*");
        System.out.println();
    }

    // methods used to check to see if a player has won
    public void checkFourInARow(Player player) {
        char color = player.getPlayerColor();

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length - 3; column++) {
                if (board[row][column] == color && board[row][column + 1] == color && board[row][column + 2] == color
                        && board[row][column + 3] == color) player.setHasWon(true);
            }
        }
    }
    public void checkFourInAColumn(Player player) {
        char color = player.getPlayerColor();

        for (int column = 0; column < 4; column++) {
            for (int row = 0; row < board.length - 3; row++) {
                if ((board[row][column] == color) && (board[row + 1][column] == color) &&
                        (board[row + 2][column] == color) && (board[row + 3][column] == color)) player.setHasWon(true);
            }
        }
    }

    public void checkFourInADiagonal(Player player) {
        char color = player.getPlayerColor();

        // start of left down check
        for (int rowStart = 0; rowStart < board.length - 3; rowStart++) {
            int row, column;
            for (row = rowStart, column = 0; (row < (board.length - 3)) && (column < (board[row].length - 3));
                 row++, column++) {
                if ((board[row][column] == color) && (board[row + 1][column + 1] == color) &&
                        (board[row + 2][column + 2] == color) && (board[row + 3][column + 3] == color))
                    player.setHasWon(true);
            }
        }
        /* end of left down check
        *
        *
        *
        *
        *
        start of right down check */
        for (int columnStart = 1; columnStart < 4; columnStart++) {
            int row, column;
            for (column = columnStart, row = 0; (row < (board.length - 3)) && (column < (board[row].length - 3));
                 row++, column++) {
                if ((board[row][column] == color) && (board[row + 1][column + 1] == color) &&
                        (board[row + 2][column + 2] == color) && (board[row + 3][column + 3] == color))
                    player.setHasWon(true);
            }
        }
       /* end of right down check
        *
        *
        *
        *
        *
        start of right up check */
        for (int rowStart = 0; rowStart < (board.length - 3); rowStart++) {
            int row, column;
            for (row = rowStart, column = 6; row < board.length - 3; row++, column--) {
                if ((board[row][column] == color) && (board[row + 1][column - 1] == color) &&
                        (board[row + 2][column - 2] == color) && (board[row + 3][column - 3] == color))
                    player.setHasWon(true);
            }
        }
        /* end of right up check
        *
        *
        *
        *
        *
        start of left up check */
        for (int columnStart = board[0].length - 1; columnStart > 2; columnStart--) {
            int row, column;
            for (column = columnStart, row = 0; row < board.length - 3 && column >= 3; row++, column--) {
                if ((board[row][column] == color) && (board[row + 1][column - 1] == color) &&
                        (board[row + 2][column - 2] == color) && (board[row + 3][column - 3] == color))
                    player.setHasWon(true);
            }
        }
        // end of left up check
    }
}
