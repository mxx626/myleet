package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSorDFS_01Matrix {
    /**
     * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
     * The distance between two adjacent cells is 1.

     Example 1:
     Input:

     0 0 0
     0 1 0
     0 0 0

     Output:

     0 0 0
     0 1 0
     0 0 0

     Example 2:
     Input:

     0 0 0
     0 1 0
     1 1 1

     Output:

     0 0 0
     0 1 0
     1 2 1

     Note:

     The number of elements of the given matrix will not exceed 10,000.
     There are at least one 0 in the given matrix.
     The cells are adjacent in only four directions: up, down, left and right.
     **/
    private int[][] ret;
    private int[][] delta = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    //BFS
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return ret;
        int rlen = matrix.length, clen = matrix[0].length;
        ret = new int[rlen][clen];
        for (int i=0; i<rlen; ++i){
            for (int j=0; j<clen; ++j){
                if (matrix[i][j]==0){
                    ret[i][j]=0;
                }
                else {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    BFS(matrix, queue, 1);
                }
            }
        }
        return ret;
    }

    private void BFS (int[][] matrix, Queue<int[]> queue, int level){
        int i = queue.peek()[0];
        int j = queue.peek()[1];
        while (!queue.isEmpty()){
            Queue<int[]> temp = new LinkedList<>();
            while (!queue.isEmpty()){
                int [] pair = queue.poll();
                int x = pair[0], y = pair[1];
                for (int[] d : delta){
                    int m = x+d[0];
                    int n = y+d[1];
                    if (m<0 || m>=matrix.length || n<0 || n>=matrix[0].length) continue;
                    if (matrix[m][n]==0) {
                        ret[i][j]=level;
                        return;
                    }
                    temp.offer(new int[]{m, n});
                }
            }
            level++;
            queue=temp;
        }
    }

    //DFS
    public int[][] updateMatrix2(int[][] matrix){
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return new int[0][0];
        int rlen = matrix.length, clen = matrix[0].length;
        for (int i=0; i<rlen; ++i){
            for (int j=0; j<clen; ++j){
                if (matrix[i][j]!=0){
                    DFS(matrix, i, j);
                }
            }
        }
        return matrix;
    }
    int[] deltaX = new int[]{0,0,1,-1};
    int[] deltaY = new int[]{1,-1,0,0};
    public void DFS (int[][] matrix, int x, int y){
        int min = Integer.MAX_VALUE;
        for (int i=0; i<4; ++i){
            int m=x+deltaX[i];
            int n=y+deltaY[i];
            if (m>=0&&m<matrix.length&&n>=0&&n<matrix[0].length){
                min=Math.min(min, matrix[m][n]+1);
            }
        }
        if (min!=matrix[x][y]){
            matrix[x][y]=min;
            for (int i=0; i<4; ++i){
                int m=x+deltaX[i];
                int n=y+deltaY[i];
                if (m>=0&&m<matrix.length&&n>=0&&n<matrix[0].length){
                    DFS(matrix, m, n);
                }
            }
        }
    }
    //DP
    public int[][] updateMatrix3(int[][] matrix){
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return ret;
        int rlen = matrix.length, clen = matrix[0].length;
        ret = new int[rlen][clen];
        for (int[] res : ret){
            Arrays.fill(res, Integer.MAX_VALUE-1);
        }
        for (int i=0; i<rlen; ++i){
            for (int j=0; j<clen; ++j){
                if (matrix[i][j]==0){
                    ret[i][j]=0;
                }
                else {
                    if (i>0) ret[i][j]=Math.min(ret[i][j], ret[i-1][j]+1);
                    if (j>0) ret[i][j]=Math.min(ret[i][j], ret[i][j-1]+1);
                }
            }
        }
        for (int i=rlen-1; i>=0; --i){
            for (int j=clen-1; j>=0; --j){
                    if (i<rlen-1) ret[i][j]=Math.min(ret[i][j], ret[i+1][j]+1);
                    if (j<clen-1) ret[i][j]=Math.min(ret[i][j], ret[i][j+1]+1);
            }
        }
        return ret;
    }
}
