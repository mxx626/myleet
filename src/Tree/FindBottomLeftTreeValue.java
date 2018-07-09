package Tree;
// TAG: Tree, DFS, BFS
public class FindBottomLeftTreeValue {
    /**
     * Given a binary tree, find the leftmost value in the last row of the tree.

     Example 1:
     Input:

     2
     / \
     1   3

     Output:
     1
     Example 2:
     Input:

     1
     / \
     2   3
     /   / \
     4   5   6
     /
     7

     Output:
     7
     Note: You may assume the tree (i.e., the given root node) is not NULL.


     */
    private int maxDepth = 0;
    private int ret      = 0;
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 1);
        return ret;
    }
    private void helper(TreeNode root, int depth)
    {
        if (root==null) return;
        if (maxDepth<depth)
        {
            maxDepth=depth;
            ret=root.val;
        }
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
