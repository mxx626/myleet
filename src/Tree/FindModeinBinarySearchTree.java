package Tree;
// Tree
import java.util.ArrayList;
import java.util.List;

public class FindModeinBinarySearchTree {
    /**
     * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than or equal to the node's key.
     The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
     Both the left and right subtrees must also be binary search trees.
     For example:
     Given BST [1,null,2,2],
     1
     \
     2
     /
     2
     return [2].

     Note: If a tree has more than one mode, you can return them in any order.

     Follow up: Could you do that without using any extra space? (Assume that the
     implicit stack space incurred due to recursion does not count).


     */
    private List<Integer> ret = new ArrayList<>();
    private int max=1;
    private int count=1;
    private Integer preVal = null;
    public int[] findMode(TreeNode root) {
        if (root==null) return new int[0];
        helper(root);
        int idx=0;
        int[] res = new int[ret.size()];
        for (int i=0; i<ret.size(); ++i){
            res[idx++]=ret.get(i);
        }
        return res;
    }
    private void helper(TreeNode root){
        if (root==null) return;
        helper(root.left);
        if (preVal!=null && root.val==preVal){
            max++;
        }
        else {
            max=1;
        }
        if (max>=count){
            if (max>count)
                ret=new ArrayList<>();
            ret.add(root.val);
            count=max;
        }
        preVal = root.val;
        helper(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
