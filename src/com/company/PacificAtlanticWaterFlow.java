package com.company;
// DFS BFS
import java.util.ArrayList;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow

 Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right
 and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height
 equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 Note:
 The order of returned grid coordinates does not matter.
 Both m and n are less than 150.
 Example:

 Given the following 5x5 matrix:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 Return:

 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

 */
public class PacificAtlanticWaterFlow {
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return res;
        boolean[][] pVisit = new boolean[matrix.length][matrix[0].length];
        boolean[][] aVisit = new boolean[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; ++i){
            dfs(matrix, i, 0, pVisit);
            dfs(matrix, i, matrix[0].length-1, aVisit);
        }
        for (int j=0; j<matrix[0].length; ++j){
            dfs(matrix, 0, j, pVisit);
            dfs(matrix, matrix.length-1, j, aVisit);
        }
        for (int i=0; i<matrix.length; ++i){
            for (int j=0; j<matrix[0].length; ++j){
                if (pVisit[i][j] && aVisit[i][j]){
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
    private void dfs(int[][] matrix, int i, int j, boolean[][] visit){
        visit[i][j]=true;
        for (int[] d : dir){
            int x = i+d[0];
            int y = j+d[1];
            if (x<0 || x>=matrix.length || y<0 || y>=matrix[0].length || visit[x][y] || matrix[x][y]<matrix[i][j])
                continue;
            dfs(matrix, x, y, visit);
        }
    }
}
