package Arrays;
// TAG: Arrays
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all
     * elements of the matrix in spiral order.

     For example,
     Given the following matrix:

     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]

     You should return [1,2,3,6,9,8,7,4,5].
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return new ArrayList<>();
        int rowStart=0, rowEnd=matrix.length-1;
        int colStart=0, colEnd=matrix[0].length-1;
        List<Integer> list = new ArrayList<>();
        while (list.size()<matrix.length*matrix[0].length){
            for (int j=colStart; j<=colEnd; ++j){
                list.add(matrix[rowStart][j]);
            }
            rowStart++;
            for (int i=rowStart; i<=rowEnd; ++i){
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowEnd>=rowStart){
                for (int j=colEnd; j>=colStart; --j){
                    list.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            if (colStart<=colEnd){
                for (int i=rowEnd; i>=rowStart; --i){
                    list.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return list;
    }
}
