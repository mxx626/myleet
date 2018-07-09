package com.company;
// HashTable
/**
 * 37. Sudoku Solver

 Write a program to solve a Sudoku puzzle by filling the empty cells.

 A sudoku solution must satisfy all of the following rules:

 Each of the digits 1-9 must occur exactly once in each row.
 Each of the digits 1-9 must occur exactly once in each column.
 Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 Empty cells are indicated by the character '.'.


 A sudoku puzzle...


 ...and its solution numbers marked in red.

 Note:

 The given board contain only digits 1-9 and the character '.'.
 You may assume that the given Sudoku puzzle will have a single unique solution.
 The given board size is always 9x9.
 */
public class SudokuSolver {
    int[][] row = new int[9][10];
    int[][] col = new int[9][10];
    int[][] cub = new int[9][10];
    public void solveSudoku(char[][] board) {
        for (int i=0; i<9; ++i){
            for (int j=0; j<9; ++j){
                char c = board[i][j];
                if (c!='.'){
                    int n = c-'0';
                    int dx = j/3;
                    int dy = i/3;
                    row[i][n]=1;
                    col[j][n]=1;
                    cub[dy*3+dx][n]=1;
                }
            }
        }
        isValid(board, 0, 0);
    }
    private boolean isValid(char[][] board, int x, int y){
        if (y==9) return true;
        int nx = (x+1)%9;
        int ny = nx==0 ? y+1 : y;
        if (board[y][x]!='.') return isValid(board, nx, ny);
        for (int i=1; i<=9; ++i){
            int dx = x/3;
            int dy = y/3;
            int _diag = dy*3+dx;
            if (row[y][i]==0 && col[x][i]==0 && cub[_diag][i]==0){
                row[y][i]=1;
                col[x][i]=1;
                cub[_diag][i]=1;
                board[y][x] = (char)(i+'0');
                if (isValid(board, nx, ny)) return true;
                board[y][x] = '.';
                cub[_diag][i]=0;
                col[x][i]=0;
                row[y][i]=0;
            }
        }
        return false;
    }
}
