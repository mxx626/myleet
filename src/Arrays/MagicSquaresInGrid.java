package Arrays;
// Array
public class MagicSquaresInGrid {
    /**
     * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

     Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).



     Example 1:

     Input: [[4,3,8,4],
     [9,5,1,9],
     [2,7,6,2]]
     Output: 1
     Explanation:
     The following subgrid is a 3 x 3 magic square:
     438
     951
     276

     while this one is not:
     384
     519
     762

     In total, there is only one magic square inside the given grid.
     Note:

     1 <= grid.length <= 10
     1 <= grid[0].length <= 10
     0 <= grid[i][j] <= 15
     * @param grid
     * @return
     */
    public int numMagicSquaresInside(int[][] grid) {
        if (grid==null || grid.length<3 || grid[0].length<3) return 0;
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i=0; i<row-2; ++i){
            for (int j=0; j<col-2; ++j){
                if (valid(grid,i,j)){
                    res++;
                }
            }
        }
        return res;
    }
    private boolean valid (int[][] grid, int i, int j){
        if (grid[i+1][j+1]!=5) return false;
        int[] count = new int[10];
        int num = 0;
        for (int x=i; x<i+3; ++x){
            for (int y=j; y<j+3; ++y){
                if (grid[x][y]>9) return false;
                num++;
                count[grid[x][y]]++;
                if (count[grid[x][y]]>1) return false;
            }
        }
        int row1 = grid[i][j]+grid[i][j+1]+grid[i][j+2];
        int row2 = grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
        int row3 = grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
        int col1 = grid[i][j]+grid[i+1][j]+grid[i+2][j];
        int col2 = grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
        int col3 = grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];
        int diag1 = grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
        int diag2 = grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];
        boolean res = (row1==15)&&(row2==15)&&(row3==15)&&(col1==15)&&(col2==15)&&(col3==15)&&(diag1==15)&&(diag2==15);
        return res && num==9;
    }
}
