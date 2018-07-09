package Tree;
// TAG: Tree, DP
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    /**
     * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

     Example:

     Input: 3
     Output:
     [
     [1,null,3,2],
     [3,2,null,1],
     [3,1,null,null,2],
     [2,1,3],
     [1,null,2,null,3]
     ]
     Explanation:
     The above output corresponds to the 5 unique BST's shown below:

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3

     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n, new List[n][n]);
    }
    private List<TreeNode> helper(int start, int end, List[][] dp){
        List<TreeNode> res = new ArrayList<>();
        if (start>end) return res;

        if (dp[start-1][end-1]!=null) return dp[start-1][end-1];

        for (int i=start; i<=end; ++i){

            List<TreeNode> left = helper(start, i-1, dp);
            List<TreeNode> right = helper(i+1, end, dp);
            if (left.isEmpty()) left.add(null);
            if (right.isEmpty()) right.add(null);

            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left=l; root.right=r;
                    res.add(root);
                }
            }
        }
        dp[start-1][end-1]=res;
        return res;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
