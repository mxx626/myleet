package Tree;
// Tree
public class SecondMinimumNodeInaBinaryTree {
    private int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

    /**
     * Given a non-empty special binary tree consisting of nodes with the
     * non-negative value, where each node in this tree has exactly two or
     * zero sub-node. If the node has two sub-nodes, then this node's value
     * is the smaller value among its two sub-nodes.

     Given such a binary tree, you need to output the second minimum value
     in the set made of all the nodes' value in the whole tree.

     If no such second minimum value exists, output -1 instead.

     Example 1:
     Input:
     2
     / \
     2   5
     / \
     5   7

     Output: 5
     Explanation: The smallest value is 2, the second smallest value is 5.
     Example 2:
     Input:
     2
     / \
     2   2

     Output: -1
     Explanation: The smallest value is 2, but there isn't any second smallest value.
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root==null) return -1;
        helper(root);
        return min2==Integer.MAX_VALUE ? -1 : min2;

    }
    private void helper(TreeNode root){
        if (root==null) return;
        if (root.val<min1){
            min2=min1;
            min1=root.val;
        }
        else if (root.val != min1 && root.val<min2) min2=root.val;
        helper(root.left);
        helper(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left, right, next;
        TreeNode(int x) { val = x; }
    }
}
