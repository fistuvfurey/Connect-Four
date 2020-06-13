package com.connectfour;

public class Player {
    private boolean isTurn;
    private char playerColor;
    private boolean hasWon;

    public Player(char playerColor) {
        this.playerColor = playerColor;
    }

    // getters
    public char getPlayerColor() {
        return playerColor;
    }
    public boolean getIsTurn() { return isTurn; }
    public boolean getHasWon() { return hasWon; }

    // setters
    public void setIsTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    public void setHasWon(boolean hasWon) { this.hasWon = hasWon; }

    public Player determineTurn(Player player) {
        if (this.getIsTurn())
            return this;
        return player;
    }

    public void changeTurns(Player player) {
        // swap values of isTurn between the two players
        boolean temp = this.getIsTurn();
        this.setIsTurn(player.getIsTurn());
        player.setIsTurn(temp);
    }
}
