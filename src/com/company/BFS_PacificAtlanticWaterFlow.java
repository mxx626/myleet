package com.company;

import java.util.*;

public class BFS_PacificAtlanticWaterFlow {
    /**
     * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
     * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the
     * right and bottom edges.
     * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
     * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
     *
     * Note:
     * The order of returned grid coordinates does not matter.
     * Both m and n are less than 150.
     *
     * Example:
     * Given the following 5x5 matrix:
     * Pacific    ~   ~   ~   ~   ~
     *         ~  1   2   2   3  (5) *
     *         ~  3   2   3  (4) (4) *
     *         ~  2   4  (5)  3   1  *
     *         ~ (6) (7)  1   4   5  *
     *         ~ (5)  1   1   2   4  *
     *            *   *   *   *   * Atlantic
     * Return:
     * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
     * */
    //DFS
    private List<int[]> ret;
    private int[][] delta = new int[][]{{0,1}, {0,-1}, {1, 0}, {-1, 0}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ret;
        int rlen = matrix.length, clen = matrix[0].length;
        byte[][] pacific = new byte[rlen][clen];
        byte[][] atlantic = new byte[rlen][clen];
        for (int i=0; i<rlen; ++i){
            DFS(matrix, i, 0, Integer.MIN_VALUE, pacific);
            DFS(matrix, i, clen-1, Integer.MIN_VALUE, atlantic);
        }
        for (int i=0; i<clen; ++i){
            DFS(matrix, 0, i, Integer.MIN_VALUE, pacific);
            DFS(matrix, rlen-1, i, Integer.MIN_VALUE, atlantic);
        }

        for (int i=0; i<rlen; ++i){
            for (int j=0; j<clen; ++j){
                if (pacific[i][j]==1 && atlantic[i][j]==1)
                    ret.add(new int[]{i, j});
            }
        }

        return ret;
    }

    private void DFS (int[][] matrix, int x, int y, int last, byte[][] visited){
        if (x<0 || x>=matrix.length || y<0 || y>=matrix[0].length || visited[x][y]==1 || matrix[x][y] < last) return;
        visited[x][y]=1;
        for (int[] coordinator : delta){
            DFS(matrix, x+coordinator[0], y+coordinator[1], matrix[x][y], visited);
        }
    }

    //BFS
    public List<int[]> pacificAtlantic2(int[][] matrix){
        ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ret;
        int rlen = matrix.length, clen = matrix[0].length;
        byte[][] pacific = new byte[rlen][clen];
        byte[][] atlantic = new byte[rlen][clen];
        Queue<int[]> qPac = new LinkedList<>();
        Queue<int[]> qAtl = new LinkedList<>();
        for (int i=0; i<rlen; ++i){
            qPac.offer(new int[]{i, 0});
            pacific[i][0]=1;
            qAtl.offer(new int[]{i, clen-1});
            atlantic[i][clen-1]=1;
        }
        for (int i=0; i<clen; ++i){
            qPac.offer(new int[]{0, i});
            pacific[0][i]=1;
            qAtl.offer(new int[]{rlen-1, i});
            atlantic[rlen-1][i]=1;
        }
        BFS(matrix, qPac, pacific);
        BFS(matrix, qAtl, atlantic);
        for (int i=0; i<rlen; ++i){
            for (int j=0; j<clen; ++j){
                if (pacific[i][j]==1 && atlantic[i][j]==1)
                    ret.add(new int[]{i, j});
            }
        }
        return ret;
    }

    private void BFS(int[][] matrix, Queue<int[]> queue, byte[][] visited){
        while (!queue.isEmpty()){
            int[] coordinator = queue.poll();
            for (int[] d : delta){
                int x = coordinator[0]+d[0];
                int y = coordinator[1]+d[1];
                if (x<0 || x>=matrix.length || y<0 || y>=matrix[0].length || visited[x][y]==1 ||
                        matrix[x][y] < matrix[coordinator[0]][coordinator[1]]) continue;
                visited[x][y]=1;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
