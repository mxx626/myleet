package com.company;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * Example:
 * Input: [[ 1, 2, 3 ],
 *         [ 4, 5, 6 ],
 *         [ 7, 8, 9 ]]
 * Output: [1,2,4,7,5,3,6,8,9]
 *
 * Explanation:
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 **/
public class Array_DiagonalTraverse {
    //Solution 1
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0) return new int[0];
        int r=0, c=0, rlen=matrix.length, clen=matrix[0].length;
        int[] res = new int[rlen*clen];
        for (int i=0; i<rlen*clen; ++i){
            res[i]=matrix[r][c];
            if ((r+c)%2==0){
                if (c==clen-1){r++;}
                else if (r==0) {c++;}
                else {c++;r--;}
            }
            else{
                if (r==rlen-1){c++;}
                else if (c==0) {r++;}
                else {r++; c--;}
            }
        }
        return res;
    }

    //Solution 2
    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix==null || matrix.length==0) return new int[0];
        if (matrix[0].length==1){
            int[] res = new int[matrix.length];
            for (int i=0; i<matrix.length; i++){
                res[i]=matrix[i][0];
            }
            return res;
        }
        boolean downward = true;
        return tranverse(matrix,true);

    }

    public int[] tranverse(int[][] matrix, boolean downward){
        int rlen=matrix.length, clen=matrix[0].length, j=1;
        System.out.println(rlen*clen);
        int[] idx = new int[2];
        int[] res = new int[rlen*clen];
        res[0]= matrix[idx[0]][idx[1]];
        idx[1]++;
        while (idx[0]+idx[1]<rlen+clen-1){
            if (idx[1]>=0 && downward){
                res[j]=(matrix[idx[0]][idx[1]]);
                System.out.println(res[j]);
                j++;
                idx[0]++;
                idx[1]--;
                if (idx[0]>=rlen){
                    idx[1]+=2;
                    idx[0]--;
                    downward=false;
                }
                else if(idx[1]<0){
                    idx[1]=0;
                    downward=false;
                }

            }
            else if (idx[0]>=0 && !downward){
                res[j]=(matrix[idx[0]][idx[1]]);
                System.out.println(res[j]);
                j++;
                idx[0]--;
                idx[1]++;
                if (idx[1]>=clen){
                    idx[1]--;
                    idx[0]+=2;
                    downward=true;
                }
                else if (idx[0]<0){
                    idx[0]++;
                    downward=true;
                }
            }
        }
        return res;
    }
}
