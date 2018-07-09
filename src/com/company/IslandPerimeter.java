package com.company;
/// DFS
public class IslandPerimeter {
    /**
     *You are given a map in form of a two-dimensional integer grid where 1 represents land and 0
     * represents water. Grid cells are connected horizontally/vertically (not diagonally). The
     * grid is completely surrounded by water, and there is exactly one island (i.e., one or more
     * connected land cells). The island doesn't have "lakes" (water inside that isn't connected
     * to the water around the island). One cell is a square with side length 1. The grid is rectangular,
     * width and height don't exceed 100. Determine the perimeter of the island.


     Example:

     [[0,1,0,0],
     [1,1,1,0],
     [0,1,0,0],
     [1,1,0,0]]

     Answer: 16
     Explanation: The perimeter is the 16 yellow stripes in the image below:

     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int num=0, neighbor=0;
        for (int i=0; i<grid.length; ++i){
            for (int j=0; j<grid[0].length; ++j){
                if (grid[i][j]==1){
                    num++;
                    if (i<grid.length-1 && grid[i+1][j]==1) neighbor++;
                    if (j<grid[0].length-1 && grid[i][j+1]==1) neighbor++;
                }
            }
        }
        return 4*num-2*neighbor;
    }


    //////////////////////////////////
    public int islandPerimeter2(int[][] grid) {
        int res = 0;
        for (int i=0; i<grid.length; ++i){
            for (int j=0; j<grid[0].length; ++j){
                if (grid[i][j]==1){
                    res = helper(grid, i, j);
                    return res;
                }
            }
        }
        return 0;
    }
    private int helper(int[][] grid, int i, int j){
        if (i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]==0) return 1;
        if (grid[i][j]==-1) return -1;
        grid[i][j]=-1;
        int left = helper(grid, i, j-1);
        int right = helper(grid, i, j+1);
        int up = helper(grid, i-1, j);
        int down = helper(grid, i+1, j);
        int res = 0;
        if (up>0) res += up;
        if (down>0) res+=down;
        if (left>0) res+= left;
        if (right>0) res+=right;
        return res;
    }
}
