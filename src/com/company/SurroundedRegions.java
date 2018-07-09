package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    /**
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * For example,
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     *
     * After running your function, the board should be:
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     */
    //DFS
    public void solve(char[][] board) {
        if (board==null || board.length==0 || board[0].length==0){
            return;
        }
        int row =board.length-1, col=board[0].length-1;
        for (int i=0; i<=row; ++i){
            if (board[i][0]=='O'){
                DFS(board, i, 0);
            }
            if (board[i][col]=='O'){
                DFS(board, i, col);
            }
        }
        for (int i=1; i<=col; ++i){
            if (board[0][i]=='O'){
                DFS(board, 0, i);
            }
            if (board[row][i]=='O'){
                DFS(board, row, i);
            }
        }

        for (int i=0; i<=row; ++i){
            for (int j=0; j<=col; ++j){
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if (board[i][j]=='1'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void DFS (char[][] board, int x, int y){
        if (x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y]!='O') {
            return;
        }
        board[x][y]='1';
        DFS(board, x+1, y);
        DFS(board, x-1, y);
        DFS(board, x, y+1);
        DFS(board, x, y-1);
    }

    //BFS
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve1(char[][] board) {
        if (board==null || board.length==0 || board[0].length==0){
            return;
        }
        int row = board.length, col = board[0].length;
        int[][] delta = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        for (int i=0; i<row; ++i){
            for (int j=0; j<col; ++j){
                if ((i==0 || i==row-1 || j==0 || j==col-1) && board[i][j]=='O'){
                    Queue<Point> queue = new LinkedList<>();
                    board[i][j]='#';
                    queue.offer(new Point(i, j));
                    while (!queue.isEmpty()){
                        Point point = queue.poll();
                        for (int k=0; k<4; ++k){
                            int x = point.x + delta[k][0];
                            int y = point.y + delta[k][1];
                            if (x>=0 && x<row && y>=0 && y<col && board[x][y]=='O'){
                                board[x][y]='#';
                                queue.offer(new Point(x, y));
                            }
                        }
                    }
                }
            }
        }
        for (int i=0; i<row; ++i){
            for (int j=0; j<col; ++j){
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if (board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
}
