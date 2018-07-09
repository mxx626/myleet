package com.company;
// TAG: Arrays, DFS

import java.util.LinkedList;
import java.util.List;

public class LonelyPixelII {
    /**
     * Given a picture consisting of black and white pixels, and a positive integer N,
     * find the number of black pixels located at some specific row R and column C that
     * align with all the following rules:

     Row R and column C both contain exactly N black pixels.
     For all rows that have a black pixel at column C, they should be exactly the same
     as row R
     The picture is represented by a 2D char array consisting of 'B' and 'W', which means
     black and white pixels respectively.

     Example:
     Input:
     [['W', 'B', 'W', 'B', 'B', 'W'],
     ['W', 'B', 'W', 'B', 'B', 'W'],
     ['W', 'B', 'W', 'B', 'B', 'W'],
     ['W', 'W', 'B', 'W', 'B', 'W']]

     N = 3
     Output: 6
     Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
     0    1    2    3    4    5         column index
     0    [['W', 'B', 'W', 'B', 'B', 'W'],
     1     ['W', 'B', 'W', 'B', 'B', 'W'],
     2     ['W', 'B', 'W', 'B', 'B', 'W'],
     3     ['W', 'W', 'B', 'W', 'B', 'W']]
     row index

     Take 'B' at row R = 0 and column C = 1 as an example:
     Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels.
     Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2. They are
     exactly the same as row R = 0.

     Note:
     The range of width and height of the input 2D array is [1,200].

     * @param picture
     * @param N
     * @return
     */
    public int findBlackPixel(char[][] picture, int N) {
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];
        int res=0;
        for (int i=0; i<picture.length; ++i){
            for (int j=0; j<picture[0].length; ++j){
                if (picture[i][j]=='B'){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i=0; i<picture[0].length; ++i){
            if (col[i]!=N) continue;
            List<Integer> list = new LinkedList<>();
            for (int j=0; j<picture.length; ++j){
                if (row[j]==N && picture[j][i]=='B')
                    list.add(j);
            }
            if (list.size()!=N) continue;
            boolean eq = true;
            for (int k=1;k<list.size();++k){
                char[] row1 = picture[list.get(k-1)];
                char[] row2 = picture[list.get(k)];
                if (!isEqual(row1, row2)){
                    eq=false;
                    break;
                }
            }
            if (eq){
                res += N;
            }
        }
        return res;
    }
    private boolean isEqual(char[] row1, char[] row2){
        for (int i=0; i<row1.length; ++i){
            if (row1[i]!=row2[i]) return false;
        }
        return true;
    }
}
