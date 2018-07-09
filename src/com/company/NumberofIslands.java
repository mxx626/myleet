package com.company;
// DFS, BFS, UF
public class NumberofIslands {
    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
     * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
     * are all surrounded by water.
     *
     * Example 1:
     * 11110
     * 11010
     * 11000
     * 00000
     * Answer: 1
     *
     * Example 2:
     * 11000
     * 11000
     * 00100
     * 00011
     * Answer: 3
     */
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int count=0;
        for (int i=0; i<grid.length; ++i){
            for (int j=0; j<grid[0].length; ++j){
                if (grid[i][j]=='1'){
                    DFS(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void DFS(int x, int y, char[][] grid){
        if (x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]=='0') return;
        grid[x][y]='0';
        DFS(x+1, y, grid);
        DFS(x-1, y, grid);
        DFS(x, y+1, grid);
        DFS(x, y-1, grid);
    }
}
