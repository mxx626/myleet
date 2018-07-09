package com.company;
/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 * [['Z','B','C','E'],
 *  ['S','A','C','S'],
 *  ['A','D','E','E']]
 *
 *  word = "ABCCED", -> returns true,
 *  word = "SEE", -> returns true,
 *  word = "ABCB", -> returns false.
 *  **/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word==null || word.length()==0) return true;
        if (board.length*board[0].length < word.length()) return false;
        for (int i=0; i<board.length; ++i){
            for (int j=0; j<board[0].length; ++j){
                if (DFS(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DFS(char[][] board, String word, int start, int i, int j){
        if (start == word.length()) return true;
        if (i<0 || i>=board.length || j<0 || j>=board[0].length)return false;// <-|
        if (board[i][j]==word.charAt(start++)){              //                   |
            char c = board[i][j];                            //                   |
            board[i][j]='#';                                 //                   |
            boolean res = DFS(board, word, start, i+1, j)  // move to right     |
                        ||DFS(board, word, start, i-1, j)  // move to left    --
                        ||DFS(board, word, start, i, j+1)  // move to downward
                        ||DFS(board, word, start, i, j-1); // move to upward
            board[i][j]=c;
            return res;
        }
        return false;
    }
}
