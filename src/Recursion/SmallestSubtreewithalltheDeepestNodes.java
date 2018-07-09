package Recursion;
// Recursion
/**
 * 866. Smallest Subtree with all the Deepest Nodes

 Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.

 A node is deepest if it has the largest depth possible among any node in the entire tree.

 The subtree of a node is that node, plus the set of all descendants of that node.

 Return the node with the largest depth such that it contains all the deepest nodes in it's subtree.



 Example 1:

 Input: [3,5,1,6,2,0,8,null,null,7,4]
 Output: [2,7,4]
 Explanation:



 We return the node with value 2, colored in yellow in the diagram.
 The nodes colored in blue are the deepest nodes of the tree.
 The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
 The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
 Both the input and output have TreeNode type.


 Note:

 The number of nodes in the tree will be between 1 and 500.
 The values of each node are unique.
 */
public class SmallestSubtreewithalltheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Node node = helper(root);
        return node.node;
    }
    private Node helper(TreeNode root){
        if (root==null) return new Node(null, 0);
        Node left =helper(root.left);
        Node right = helper(root.right);
        if (left.val > right.val) return new Node(left.node, left.val+1);
        if (right.val > left.val) return new Node(right.node, right.val+1);
        return new Node(root, 1+left.val);

    }
    class Node {
        TreeNode node;
        int val;
        public Node(TreeNode node, int val){
            this.node = node;
            this.val = val;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
}
