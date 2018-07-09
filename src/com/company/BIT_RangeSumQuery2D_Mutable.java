package com.company;

public class BIT_RangeSumQuery2D_Mutable {
    private int[][] nums;
    private int[][] tree;
    private int rlen;
    private int clen;
    public BIT_RangeSumQuery2D_Mutable(int[][] nums) {
        if (nums.length ==  0 || nums == null || nums[0].length == 0) return;
        int rlen = nums.length;
        int clen = nums[0].length;
        nums = new int[rlen][clen];
        tree = new int[rlen+1][clen+1];
        for (int i = 0; i < rlen; i++){
            for (int j = 0; j < clen; j++){
                update(i, j, nums[i][j]);
            }
        }
    }

    public void update(int i, int j, int val) {
        if (rlen == 0 || clen == 0) return;
        int diff = val - nums[i][j];
        nums[i][j] = val;
        for (int m = i+1; m <= rlen; m += (m & (-m))){
            for (int n = j+1; n <= clen; n += (n & (-n))){
                tree[i][j] += diff;
            }
        }
    }

    public int sumRange(int row1, int col1, int row2, int col2) {

        return sum(row2+1, col2+1) - sum(row1, col2+1) - sum(row2+1, col1) + sum(row1, col1);
    }

    public int sum (int rlen, int clen){
        int sum=0;
        for (int i = rlen; i > 0; i -= (i & (-i))){
            for (int j = clen; j > 0; j -= (j & (-j))){
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
