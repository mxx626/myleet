package Backtracking;
// Backtracking
public class BeautifulArrangement {
    /**
     *
     * 526. Beautiful Arrangement
     *
     *
     * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array
     * that is constructed by these N numbers successfully if one of the following is true for
     * the ith position (1 <= i <= N) in this array:

     The number at the ith position is divisible by i.
     i is divisible by the number at the ith position.
     Now given N, how many beautiful arrangements can you construct?

     Example 1:
     Input: 2
     Output: 2
     Explanation:

     The first beautiful arrangement is [1, 2]:

     Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

     Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

     The second beautiful arrangement is [2, 1]:

     Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

     Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
     Note:
     N is a positive integer and will not exceed 15.

     * @param N
     * @return
     */
    public int countArrangement(int N) {
        int[] arr = new int[N+1];

        for (int i=1; i<N+1; ++i){
            arr[i]=i;
        }

        return helper(arr, 1);
    }

    private int helper(int[] arr, int pos){
        if (pos==arr.length){
            return 1;
        }
        int count=0;
        for (int i=pos; i<arr.length; ++i){
            if (pos%arr[i]==0 || arr[i]%pos==0){
                swap(arr, i, pos);
                count += helper(arr, pos+1);
                swap(arr, i, pos);
            }
        }
        return count;
    }
    private void swap (int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
