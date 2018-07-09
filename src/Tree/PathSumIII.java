package Tree;
// Tree
import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    /**
     * You are given a binary tree in which each node contains an integer value.

     Find the number of paths that sum to a given value.

     The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

     The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

     Example:

     root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

     10
     /  \
     5   -3
     / \    \
     3   2   11
     / \   \
     3  -2   1

     Return 3. The paths that sum to 8 are:

     1.  5 -> 3
     2.  5 -> 2 -> 1
     3. -3 -> 11
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }
    private int helper(TreeNode root, int curSum, int target, Map<Integer, Integer> map){
        if (root==null) return 0;
        curSum += root.val;
        int res = map.getOrDefault(curSum-target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0)+1);
        res += helper(root.left, curSum, target, map)+helper(root.right, curSum, target, map);
        map.put(curSum, map.getOrDefault(curSum, 0)-1);
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
