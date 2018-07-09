package Tree;
// Tree, DFS< Level order
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;

public class FindLargestValueinEachTreeRow {
    /**
     * You need to find the largest value in each row of a binary tree.

     Example:
     Input:

     1
     / \
     3   2
     / \   \
     5   3   9

     Output: [1, 3, 9]

     */
    LinkedList<Integer> list = new LinkedList<>();
    public List<Integer> largestValues(TreeNode root) {
        helper(root, 0);
        return list;
    }
    private void helper(TreeNode root, int level)
    {
        if (root==null) return;
        if (list.size()<=level)
        {
            list.add(root.val);
        }
        else {
            if (root.val>list.get(level))
            {
                list.set(level, root.val);
            }
        }
        helper(root.left, level+1);
        helper(root.right, level+1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
