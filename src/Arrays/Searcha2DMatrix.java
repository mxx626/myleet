package Arrays;
// TAG: Array, Binary Search, Two pointer
public class Searcha2DMatrix {
    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:

     Integers in each row are sorted from left to right.
     The first integer of each row is greater than the last integer of the previous row.
     For example,

     Consider the following matrix:

     [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     Given target = 3, return true.
     * @param matrix
     * @param target
     * @return
     */

    //matrix[mid / m][mid % m] < target
    public boolean searchMatrix1(int[][] matrix, int target) {
        int r = matrix.length-1, c=0;
        while (r>=0 && c<matrix[0].length){
            if (matrix[r][c]==target) return true;
            else if (matrix[r][c]>target){
                r--;
            }
            else {
                c++;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0) return false;
        int l=0, r=matrix.length-1, row=0;
        while(l+1<r){
            int m = l + (r-l)/2;
            if (matrix[m][0]==target) return true;
            else if (matrix[m][0]<target) l=m;
            else {
                r=m;
            }
        }
        if (matrix[r][0]<=target) row=r;
        else if (matrix[l][0]<=target) row=l;
        else return false;
        l=0; r=matrix[0].length-1;
        while (l+1<r){
            int m = l+(r-l)/2;
            if (matrix[row][m]==target) return true;
            else if (matrix[row][m]<target) l=m;
            else {
                r=m;
            }
        }
        if (matrix[row][l]==target || matrix[row][r]==target) return true;
        return false;
    }
}
