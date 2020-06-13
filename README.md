# Connect Four
This is a game of Connect Four that is run as a command line application.
Install Java on your machine and compile the code from the command line
then run PlayGame.java to play!

Connect Four is an intense and strategic game where two players, Red and Yellow,
compete to be the first to get four of their color in a row!

## Structure
PlayGame.java contains the main method in which the gameplay loop takes place.
This control loops until either a player has won or there is a draw. Then
the method prints the results.

Board.java is the blueprint for the Board object. This composes of the main 
Board UI as well as methods for dropping chips into the board and checking
for four of the same color in a row (victory!).

Player.java is the blueprint for the Player object. Two players are intialized
in the main method. This class has methods for determining and swapping player
turn.

Enjoy! 


