package HashTable;
// TAG: HashTable, BFS
import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    /**
     * Given a binary tree, return the vertical order traversal of its nodes' values.
     * (ie, from top to bottom, column by column).

     If two nodes are in the same row and column, the order should be from left to right.

     Examples:

     Given binary tree [3,9,20,null,null,15,7],
     3
     /\
     /  \
     9  20
     /\
     /  \
     15   7
     return its vertical order traversal as:
     [
     [9],
     [3,15],
     [20],
     [7]
     ]
     Given binary tree [3,9,8,4,0,1,7],
     3
     /\
     /  \
     9   8
     /\  /\
     /  \/  \
     4  01   7
     return its vertical order traversal as:
     [
     [4],
     [9],
     [3,0,1],
     [8],
     [7]
     ]
     Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
     /\
     /  \
     9   8
     /\  /\
     /  \/  \
     4  01   7
     /\
     /  \
     5   2
     return its vertical order traversal as:
     [
     [4],
     [9,5],
     [3,0,1],
     [8,2],
     [7]
     ]
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> l = new LinkedList<>();
        int idx=0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        q.add(root);
        l.add(0);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            int arr = l.get(idx++);
            min = Math.min(arr, min);
            max = Math.max(arr, max);
            map.putIfAbsent(arr, new LinkedList<>());
            map.get(arr).add(cur.val);
            if (cur.left!=null){
                q.offer(cur.left);
                l.offer(arr-1);
            }
            if (cur.right!=null){
                q.offer(cur.right);
                l.offer(arr+1);
            }
        }
        for (int i=min; i<=max; ++i){
            res.add(map.get(i));
        }
        return res;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }
}
