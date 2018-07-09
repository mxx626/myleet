package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    /**
     * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
     * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
     * A partially filled sudoku which is valid.
     *
     * Note:
     * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
     *     0-4 1            3-7  2          6-10 3
     *  00  01  02      03  04  05      06  07  08
     *  10  11  12      13  14  15      16  17  18
     *  20  21  22      23  24  25      26  27  28
     *     3-7              6-10            9-13
     *  30  31  32      33  34  35      36  37  38
     *  40  41  42      43  44  45      46  47  48
     *  50  51  52      53  54  55      56  57  58
     *      6-10            9-13            12-16
     *  60  61  62      63  64  65      66  67  68
     *  70  71  72      73  74  75      76  77  78
     *  80  81  82      83  84  85      86  87  88
     *
     *  int rowIdx = 3 * (i/3);
     *  int colIdx = 3 * (i%3);
     *  0   1   2   3   4   5   6   7   8
     *  0   0   0   3   3   3   6   6   6   rowIdx
     *  0   1   2   0   1   2   0   1   2   colIdx
     *
     *  0   0   0   1   1   1   2   2   2   j/3;
     *  0   1   2   0   1   2   0   1   2   j%3
     *
     * */
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; ++i) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    System.out.println(board[i][j]);
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                int rowIdx = 3 *(i/3);
                int colIdx = 3 *(i%3);
                if (board[rowIdx+j/3][colIdx+j%3]!='.' && !cube.add(board[rowIdx+j/3][colIdx+j%3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
