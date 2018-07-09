package Arrays;
// TAG: Array, DP
public class MaxAreaofIsland {
    /**
     * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
     * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid
     * are surrounded by water.

     Find the maximum area of an island in the given 2D array. (If there is no island, the maximum
     area is 0.)

     Example 1:

     [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,1,1,0,1,0,0,0,0,0,0,0,0],
     [0,1,0,0,1,1,0,0,1,0,1,0,0],
     [0,1,0,0,1,1,0,0,1,1,1,0,0],
     [0,0,0,0,0,0,0,0,0,0,1,0,0],
     [0,0,0,0,0,0,0,1,1,1,0,0,0],
     [0,0,0,0,0,0,0,1,1,0,0,0,0]]

     Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

     Example 2:

     [[0,0,0,0,0,0,0,0]]

     Given the above grid, return 0.

     Note: The length of each dimension in the given grid does not exceed 50.
     */
    private static final int[][] delta = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int res=0;
        for (int i=0; i<grid.length; ++i){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]==1 && !visit[i][j]){
                    res=Math.max(res, helper(grid, i, j, visit));
                }
            }
        }
        return res;
    }
    private int helper (int[][] grid, int i, int j, boolean[][] visit){
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || visit[i][j]) return 0;
        visit[i][j]=true;
        int sum=1;
        for (int[] d : delta){
            int x = i+d[0];
            int y = j+d[1];
            if (x>=0 && x<grid.length && y>=0 && y<grid[0].length){
                sum += helper(grid, x, y, visit);
            }
        }
        return sum;
    }

    // Simplifier
    public int maxAreaOfIsland2(int[][] grid) {
        int res=0;
        for (int i=0; i<grid.length; ++i){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]==1){
                    res=Math.max(res, helper(grid, i, j));
                }
            }
        }
        return res;
    }
    private int helper (int[][] grid, int i, int j){
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return 0;
        grid[i][j]=0;
        return 1+helper(grid, i+1, j)
                +helper(grid, i-1, j)
                +helper(grid, i, j+1)
                +helper(grid, i, j-1);
    }
}
