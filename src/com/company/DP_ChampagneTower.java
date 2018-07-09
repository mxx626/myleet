package com.company;

import java.util.ArrayList;
import java.util.List;

public class DP_ChampagneTower {
    /**
     * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on
     * until the 100th row.  Each glass holds one cup (250ml) of champagne. Then, some champagne is poured in
     * the first glass at the top.  When the top most glass is full, any excess liquid poured will fall equally
     * to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne
     * will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has it's
     * excess champagne fall on the floor.)
     * For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne
     * are poured, the two glasses on the second row are half full.  After three cups of champagne are poured,
     * those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured,
     * the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.
     * **/
    public double champagneTower(int poured, int query_row, int query_glass) {
        int kRow = 100;
        double[][] dp = new double[kRow][kRow];
        dp[0][0]=poured;
        for (int i=0; i<kRow-1; i++){
            for (int j=0; j<=i; j++){
                if (dp[i][j]>1){
                    dp[i+1][j  ] += (dp[i][j]-1)/2.0;
                    dp[i+1][j+1] += (dp[i][j]-1)/2.0;
                }
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }
}
