package com.company;

public class Recursion_ValidTicTacToeState {
    /**
     * A Tic-Tac-Toe board is given as a string array board. Return True if and only
     * if it is possible to reach this board position during the course of a valid tic-tac-toe game.

     The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.

     Here are the rules of Tic-Tac-Toe:

     Players take turns placing characters into empty squares (" ").
     The first player always places "X" characters, while the second player always places "O" characters.
     "X" and "O" characters are always placed into empty squares, never filled ones.
     The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
     The game also ends if all squares are non-empty.
     No more moves can be played if the game is over.

     Example 1:
     Input: board = ["O  ", "   ", "   "]
     Output: false
     Explanation: The first player always plays "X".

     Example 2:
     Input: board = ["XOX", " X ", "   "]
     Output: false
     Explanation: Players take turns making moves.

     Example 3:
     Input: board = ["XXX", "   ", "OOO"]
     Output: false

     Example 4:
     Input: board = ["XOX", "O O", "XOX"]
     Output: true

     Note:

     board is a length-3 array of strings, where each string board[i] has length 3.
     Each board[i][j] is a character in the set {" ", "X", "O"}.

     * **/
    public boolean validTicTacToe(String[] board) {
        char[][] toBoard = new char[3][3];
        for (int i=0; i<toBoard.length; ++i){
            toBoard[i]=board[i].toCharArray();
        }
        int countX=0, countO=0;
        for (int i=0; i<3; ++i){
            for (int j=0; j<3; ++j){
                if (toBoard[i][j]=='X') countX++;
                if (toBoard[i][j]=='O') countO++;
            }
        }
        if (countX<countO || countX-countO>1) return false;
        if (countX==countO){
            if (!helper(toBoard, 'X')){
                return false;
            }
        }
        if (countX-countO==1){
            if (!helper(toBoard, 'O')){
                return false;
            }
        }
        return true;
    }
    private boolean helper (char[][] toBoard, char c){
        for (int i=0; i<3; i++){
            if (toBoard[0][i]==c && toBoard[1][i]==c && toBoard[2][i]==c) return false;
            if (toBoard[i][0]==c && toBoard[i][1]==c && toBoard[i][2]==c) return false;
            if (toBoard[0][0]==c && toBoard[1][1]==c && toBoard[2][2]==c) return false;
            if (toBoard[0][2]==c && toBoard[1][1]==c && toBoard[2][0]==c) return false;
        }
        return true;
    }
}
