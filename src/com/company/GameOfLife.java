package com.company;
// TAG: Arrays
/**
 *  According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised
 *  by the British mathematician John Horton Conway in 1970." Given a board with m by n cells, each cell has an initial
 *  state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the
 *  following four rules (taken from the above Wikipedia article):
 *
 *  Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 *  Any live cell with two or three live neighbors lives on to the next generation.
 *  Any live cell with more than three live neighbors dies, as if by over-population..
 *  Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 *  Write a function to compute the next state (after one update) of the board given its current state.
 *  Follow up:
 *  Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some
 *  cells first and then use their updated values to update other cells. In this question, we represent the board using
 *  a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the
 *  border of the array. How would you address these problems?
 *
 *  !!!!!!!!!!!!!!Bit manipulation
 *  **/
public class GameOfLife {

    public void gameOfLife1(int[][] board) {
        int rlen = board.length, clen = board[0].length;
        for (int i=0; i<rlen; ++i){
           for (int j=0; j<clen; ++j){
               if (board[i][j]==1){
                   if (computeNeigbor(i, j, board)<2 || computeNeigbor(i, j, board)>3){
                       board[i][j]=3;
                   }
               }
               else if (board[i][j]==0){
                   if (computeNeigbor(i, j, board)==2){
                       board[i][j]=2;
                   }
               }
           }
       }
        for (int i=0; i<rlen; ++i){
            for (int j=0; j<clen; ++j){
                if (board[i][j]==3) board[i][j]=0;
                else if (board[i][j]==2) board[i][j]=1;
            }
        }
    }

    public int computeNeigbor (int r, int c, int[][] board){
        int[] row = new int[]{r-1,r,r+1};
        int[] col = new int[]{c-1,c,c+1};
        int sum=0;
        for (int i : row){
            for (int j : col){
                if (i>=0 && i<board.length && j>=0 && j<board[0].length){
                    if (board[i][j]==3){
                        sum+=1;
                    }
                    else if (board[i][j]==2){
                        continue;
                    }
                    else sum+=board[r][c];
                }
            }
        }

        return sum-board[r][c];
    }




    public void gameOfLife(int[][] board) {
        int rlen = board.length, clen = board[0].length;
        int[][] tmp = new int[rlen+2][clen+2];
        for (int i=1; i<rlen+1; ++i){
            for (int j=1; j<clen+1; ++j){
                tmp[i][j]=board[i-1][j-1];
            }
        }
        for (int i=1; i<rlen+1; ++i){
            for (int j=1; j<clen+1; ++j){
                if (tmp[i][j]==1){
                    if (computerNeighbor(i, j, tmp)<2 || computerNeighbor(i, j, tmp)>3) {
                        board[i-1][j-1]=0;
                    }
                    else board[i-1][j-1]=1;
                }
                else if (tmp[i][j]==0){
                    if (computerNeighbor(i, j, tmp)==3){
                        board[i-1][j-1]=1;
                    }
                }
            }
        }
    }
    public int computerNeighbor(int i, int j, int[][] tmp){
        int sum=0;
        for (int r = i-1; r<=i+1; ++r){
            for (int c = j-1; c<=j+1; ++c){
                sum+=tmp[r][c];
            }
        }
        return sum-tmp[i][j];
    }
}
