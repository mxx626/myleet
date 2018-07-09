package Arrays;
// TAG: Array, Binary Tree
import javax.swing.tree.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.

     Note:
     You may assume that duplicates do not exist in the tree.

     For example, given

     preorder = [3,9,20,15,7]
     inorder = [9,3,15,20,7]
     Return the following binary tree:

     3
     / \
     9  20
     /  \
     15   7
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // for (int i=0; i<inorder.length; ++i){
        //     map.put(inorder[i], i);
        // }
        return contruct(preorder, inorder, 0, preorder.length-1, 0);
    }
    private TreeNode contruct(int[] pre, int[] in, int inS, int inE, int preS){
        if (preS>pre.length-1 || inS > inE) return null;
        TreeNode node = new TreeNode (pre[preS]);
        int idx = 0;
        for (int i=inS; i<=inE; ++i){
            if (in[i]==pre[preS]){
                idx=i;
            }
        }
        int leftLen = idx-inS;
        node.left = contruct (pre, in, inS, idx-1, preS+1);
        node.right = contruct (pre, in, idx+1, inE, preS+leftLen+1);
        return node;
    }
}
