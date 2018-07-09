package com.company;
// Tree, DFS
import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    /**
     *
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        if (root==null) return 0;
        int[] res = robSum(root);
        return Math.max(res[0], res[1]);
    }
    private int[] robSum(TreeNode root){
        int[] res = new int[2];
        if (root==null) return res;
        int[] left = robSum(root.left);
        int[] right = robSum(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val+left[0]+right[0];
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }
    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);
        return val;
    }
}
