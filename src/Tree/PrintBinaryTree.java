package Tree;
// Tree,
import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    /**
     * Print a binary tree in an m*n 2D string array following these rules:

     The row number m should be equal to the height of the given binary tree.
     The column number n should always be an odd number.
     The root node's value (in string format) should be put in the exactly middle
     of the first row it can be put. The column and the row where the root node
     belongs will separate the rest space into two parts (left-bottom part and
     right-bottom part). You should print the left subtree in the left-bottom
     part and print the right subtree in the right-bottom part. The left-bottom
     part and the right-bottom part should have the same size. Even if one subtree
     is none while the other is not, you don't need to print anything for the none
     subtree but still need to leave the space as large as that for the other subtree.
     However, if two subtrees are none, then you don't need to leave space for both of them.
     Each unused space should contain an empty string "".
     Print the subtrees following the same rules.
     Example 1:
     Input:
     1
     /
     2
     Output:
     [["", "1", ""],
     ["2", "", ""]]
     */
    private List<List<String>> res = new ArrayList<>();
    private int len = 0, height=0;
    public List<List<String>> printTree(TreeNode root) {
        height = getHeight(root);
        int len = (int)Math.pow(2, height)-1;
        for (int i=0; i<height; ++i)
        {
            List<String> list = new ArrayList<>();
            for (int j=0; j<len; ++j)
            {
                list.add("");
            }
            res.add(list);
        }
        helper(root, 0, len, 0);
        return res;
    }
    private void helper(TreeNode root, int s, int e, int level)
    {
        if (root==null) return;
        int idx = (s+e)/2;
        res.get(level).set(idx, Integer.toString(root.val));
        helper(root.left, s, idx, level+1);
        helper(root.right, idx, e, level+1);
    }
    private int getHeight(TreeNode root)
    {
        if (root==null) return 0;
        return 1+Math.max(getHeight(root.left), getHeight(root.right));
    }

    public class TreeNode {
        int val;
        TreeNode left, right, next;
        TreeNode(int x) { val = x; }
    }
}
