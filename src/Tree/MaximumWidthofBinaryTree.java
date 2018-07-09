package Tree;
// Tree, BFS, DFS
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaximumWidthofBinaryTree {
    /**
     * Given a binary tree, write a function to get the maximum width of the given tree. The width of a
     * tree is the maximum width among all levels. The binary tree has the same structure as a full binary
     * tree, but some nodes are null.

     The width of one level is defined as the length between the end-nodes (the leftmost and right most
     non-null nodes in the level, where the null nodes between the end-nodes are also counted into the
     length calculation.

     Example 1:
     Input:

     1
     /   \
     3     2
     / \     \
     5   3     9

     Output: 4
     Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
     Example 2:
     Input:

     1
     /
     3
     / \
     5   3

     Output: 2
     Explanation: The maximum width existing in the third level with the length 2 (5,3).
     Example 3:
     Input:

     1
     / \
     3   2
     /
     5

     Output: 2
     Explanation: The maximum width existing in the second level with the length 2 (3,2).
     Example 4:
     Input:

     1
     / \
     3   2
     /     \
     5       9
     /         \
     6           7
     Output: 8
     Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


     Note: Answer will in the range of 32-bit signed integer.
     * @param root
     * @return
     */
    private int ret = 1;
    public int widthOfBinaryTree1(TreeNode root) {
        if (root==null) return 0;
        helper(root, 0, 0, new ArrayList<>());
        return ret;
    }
    private void helper(TreeNode root, int level, int idx, List<Integer> startList)
    {
        if (root==null) return;
        if (startList.size()<=level)
            startList.add(idx);
        ret = Math.max(ret, idx - startList.get(level)+1);
        helper(root.left, level+1, idx*2, startList);
        helper(root.right, level+1, idx*2+1, startList);
    }

    ///////////////////////////////////////////////////////
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> pos = new LinkedList<>();
        int ret = 1;
        q.offer(root); pos.offer(0);
        while(!q.isEmpty())
        {
            int size = q.size();
            for (int i=0; i<size; ++i)
            {
                TreeNode cur = q.poll();
                int idx = pos.poll();
                if (cur.left!=null) {
                    q.offer(cur.left);
                    pos.offer(2*idx);
                }
                if (cur.right!=null)
                {
                    q.offer(cur.right);
                    pos.offer(2*idx+1);
                }
            }
            if (pos.size()==0) break;
            ret = Math.max(ret, pos.peekLast()-pos.peekFirst()+1);
        }
        return ret;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
