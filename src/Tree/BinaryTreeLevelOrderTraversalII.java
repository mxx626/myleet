package Tree;
// Tree, BFS
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

     For example:
     Given binary tree [3,9,20,null,null,15,7],
     3
     / \
     9  20
     /  \
     15   7
     return its bottom-up level order traversal as:
     [
     [15,7],
     [9,20],
     [3]
     ]

     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null) return new ArrayList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<>();
            int size = list.size();
            for (int i=0; i<size; ++i){
                TreeNode cur = list.poll();
                tmp.add(cur.val);
                if (cur.left!=null) list.offer(cur.left);
                if (cur.right!=null) list.offer(cur.right);
            }
            res.add(0, tmp);
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
