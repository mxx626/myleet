package com.company;
// Tree, HashMap
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    /**
     * Given a binary tree, return all duplicate subtrees. For each kind of duplicate
     * subtrees, you only need to return the root node of any one of them.

     Two trees are duplicate if they have the same structure with same node values.

     Example 1:
     1
     / \
     2   3
     /   / \
     4   2   4
     /
     4
     The following are two duplicate subtrees:
     2
     /
     4
     and
     4
     Therefore, you need to return above trees' root in the form of a list.
     */
    private List<TreeNode> res = new ArrayList<>();
    private HashMap<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root==null) return res;
        helper(root);
        return res;
    }
    private String helper(TreeNode root)
    {
        if (root==null) return "-";
        String left = helper(root.left);
        String right = helper(root.right);
        String s = left+","+right+","+root.val;
        map.put(s, map.getOrDefault(s, 0)+1);
        if (map.get(s)==2)
            res.add(root);
        return s;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
