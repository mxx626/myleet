package com.company;
// DP
public class BombEnemy {
    /**
     * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
     * (the number zero), return the maximum enemies you can kill using one bomb.
     The bomb kills all the enemies in the same row and column from the planted
     point until it hits the wall since the wall is too strong to be destroyed.
     Note that you can only put the bomb at an empty cell.

     Example:
     For the given grid

     0 E 0 0
     E 0 W E
     0 E 0 0

     return 3. (Placing a bomb at (1,1) kills 3 enemies)
     * @param grid
     * @return
     */
    public int maxKilledEnemies(char[][] grid) {
        int r=grid.length, c= r==0 ? 0 : grid[0].length;
        int res=0, rowHit=0;
        int colHit[] = new int[c];
        for (int i=0; i<r; ++i){
            for (int j=0; j<c; ++j){
                if (j==0 || grid[i][j-1]=='W'){
                    rowHit=0;
                    for (int k=j; k<c&&grid[i][k]!='W'; k++){
                        rowHit += grid[i][k]=='E' ? 1 : 0;
                    }
                }
                if (i==0 || grid[i-1][j]=='W')
                {
                    colHit[j] =0;
                    for (int l=i; l<r&&grid[l][j]!='W'; l++){
                        colHit[j] += grid[l][j]=='E' ? 1 : 0;
                    }
                }

                if (grid[i][j]=='0') res = Math.max(res, colHit[j]+rowHit);
            }
        }
        return res;
    }
}
