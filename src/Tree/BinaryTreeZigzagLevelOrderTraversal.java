package Tree;
// TAG: Tree, BFS, Stack
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     *
     Given a binary tree, return the zigzag level order traversal of its nodes' values.
     (ie, from left to right, then right to left for the next level and alternate between).

     For example:
     Given binary tree [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     return its zigzag level order traversal as:
     [
     [3],
     [20,9],
     [15,7]
     ]
     */
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null) return res;
        helper(root, 0);
        return res;
    }
    private void helper(TreeNode root, int level){
        if (root==null) return;
        if (res.size()<=level){
            res.add(new LinkedList<>());
        }
        if (level%2==0) res.get(level).add(root.val);
        else res.get(level).add(0, root.val);
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
