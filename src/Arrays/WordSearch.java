package Arrays;
// TAG: Backtracking, array
public class WordSearch {
    /**
     * Given a 2D board and a word, find if the word exists in the grid.

     The word can be constructed from letters of sequentially adjacent cell,
     where "adjacent" cells are those horizontally or vertically neighboring.
     The same letter cell may not be used more than once.

     For example,
     Given board =

     [
     ['A','B','C','E'],
     ['S','F','C','S'],
     ['A','D','E','E']
     ]
     word = "ABCCED", -> returns true,
     word = "SEE", -> returns true,
     word = "ABCB", -> returns false.
     */
    public boolean exist(char[][] board, String word) {
        if (word==null || word.length()==0) return true;
        for (int i=0; i<board.length; ++i){
            for (int j=0; j<board[0].length; ++j){
                if (board[i][j]==word.charAt(0) && helper(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int len, int i, int j){
        if (len==word.length()){
            return true;
        }
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(len)) return false;
        board[i][j]^=256;
        boolean res = helper(board, word, len+1, i-1, j)
                ||helper(board, word, len+1, i+1, j)
                ||helper(board, word, len+1, i, j+1)
                ||helper(board, word, len+1, i, j-1);
        board[i][j]^=256;
        return res;
    }
}
