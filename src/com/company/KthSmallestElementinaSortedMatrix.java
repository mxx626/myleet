package com.company;
// TAG: Binary Search, Heap
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
    /**
     * Given a n x n matrix where each of the rows and columns are sorted in ascending
     * order, find the kth smallest element in the matrix.

     Note that it is the kth smallest element in the sorted order, not the kth distinct element.

     Example:

     matrix = [
     [ 1,  5,  9],
     [10, 11, 13],
     [12, 13, 15]
     ],
     k = 8,

     return 13.
     Note:
     You may assume k is always valid, 1 ≤ k ≤ n2.


     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<matrix.length; ++i){
            for (int j=0; j<matrix[0].length; ++j){
                pq.offer(matrix[i][j]);
            }
        }
        while (k!=1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }

    public int kthSmallest3(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return matrix[o1[0]][o1[1]]-matrix[o2[0]][o2[1]];
            }
        });
        pq.offer(new int[]{0,0});
        int count=0;
        while (count!=k-1){
            int[] arr = pq.poll();
            count++;
            if(arr[0]==0 && arr[1]+1<matrix[0].length){
                pq.offer(new int[]{arr[0], arr[1]+1});
            }
            if (arr[0]+1<matrix.length){
                pq.offer(new int[]{arr[0]+1, arr[1]});
            }
        }
        return matrix[pq.peek()[0]][pq.peek()[1]];
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n=matrix.length-1;
        int left = matrix[0][0], right = matrix[n][n];
        while (left<right){
            int m = left + (right-left)/2;
            int num = count(matrix, m);
            if (num<k) left=m+1;
            else right=m;
        }
        return left;
    }
    private int count (int[][] matrix, int target){
        int n=matrix.length;
        int i=n-1, j=0;
        int res=0;
        while (i>=0 && j<n){
            if (matrix[i][j]<=target){
                res += i+1;
                j++;
            }
            else i--;
        }
        return res;
    }
}
