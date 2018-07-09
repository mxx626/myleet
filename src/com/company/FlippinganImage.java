package com.company;

public class FlippinganImage {
    /**
     * Given a binary matrix A, we want to flip the image horizontally, then invert it,
     * and return the resulting image.

     To flip an image horizontally means that each row of the image is reversed.
     For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

     To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
     For example, inverting [0, 1, 1] results in [1, 0, 0].
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A){
            int i=0, j=row.length-1;
            while (i<j){
                int tmp = row[i];
                row[i] = row[j];
                row[i] ^= 1;
                row[j] = tmp;
                row[j] ^= 1;
                i++;
                j--;
            }
            if (i==j) row[i] ^= 1;
        }
        return A;
    }
}
