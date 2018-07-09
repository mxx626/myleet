package Tree;
// TAG: Tree, Memorization, DP
public class UniqueBinarySearchTrees{
    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

     Example:

     Input: 3
     Output: 5
     Explanation:
     Given n = 3, there are a total of 5 unique BST's:

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3
     */
    private int[] dp;
    public int numTrees(int n) {
        dp = new int[n+1];
        return helper(n);
    }
    private int helper(int n){
        if (n<1) return 1;
        if (dp[n]>0) return dp[n];
        int res=0, i=1;
        while (i<=n){
            res+=(helper(i-1)*helper(n-i));
            i++;
        }
        dp[n]=res;
        return dp[n];
    }

}
