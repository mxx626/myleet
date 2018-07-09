package DFSorBFS;
// BFS, DP
import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix {
    /**
     * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

     The distance between two adjacent cells is 1.
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
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visit = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; ++i){
            for (int j=0; j<matrix[0].length; ++j){
                if (matrix[i][j]==0){
                    queue.offer(new int[]{i, j});
                }
                else {
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int[] d : dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if (x>=0 && y>=0 && x<matrix.length && y<matrix[0].length && matrix[x][y]>matrix[cur[0]][cur[1]]){
                    queue.offer(new int[]{x, y});
                    matrix[x][y] = matrix[cur[0]][cur[1]]+1;
                }
            }
        }
        return matrix;
    }


    public int[][] updateMatrix2(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        for (int i=0; i<row; ++i){
            for (int j=0; j<col; ++j){
                if (matrix[i][j]==0) continue;
                else {
                    if (i==0 && j==0) matrix[i][j]=100000;
                    else if (i==0) matrix[i][j]=matrix[i][j-1]+1;
                    else if (j==0) matrix[i][j]=matrix[i-1][j]+1;
                    else matrix[i][j]=1+Math.min(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        for (int i=row-1; i>=0; --i){
            for  (int j=col-1; j>=0; --j){
                if (matrix[i][j]==0 || (i==row-1 && j==col-1)) continue;
                else {
                    if (i==row-1) matrix[i][j]=Math.min(matrix[i][j], 1+matrix[i][j+1]);
                    else if (j==col-1) matrix[i][j]=Math.min(matrix[i][j], 1+matrix[i+1][j]);
                    else matrix[i][j]=Math.min(matrix[i][j],1+Math.min(matrix[i+1][j], matrix[i][j+1]));
                }
            }
        }
        return matrix;
    }
}
