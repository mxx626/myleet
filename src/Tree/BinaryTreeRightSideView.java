package Tree;
// TAG: Tree, Recursion
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    /**
     *Given a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.

     For example:
     Given the following binary tree,

     1            <---
     /   \
     2     3         <---
     \     \
     5     4       <---


     You should return [1, 3, 4].
     */
    private List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            res.add(q.peek().val);
            for (int i=0; i<size; ++i){
                TreeNode cur = q.poll();
                if (cur.right!=null) q.offer(cur.right);
                if (cur.left!=null) q.offer(cur.left);
            }
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
