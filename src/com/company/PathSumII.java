package com.company;
// Tree, DFS, Iterative
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
    /**
     *
     */
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        helper(root, new ArrayList<>(), sum);
        return res;
    }
    private void helper(TreeNode root, List<Integer> list, int sum){
        if (root==null) return;
        list.add(root.val);
        if (sum==root.val && root.left==null && root.right==null){
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        helper(root.left, list, sum-root.val);
        helper(root.right, list, sum-root.val);
        list.remove(list.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        int pathSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                path.add(cur.val);
                pathSum += cur.val;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            }
            if (cur.left == null && cur.right == null && pathSum == sum) {
                res.add(new ArrayList<>(path));
            }
            stack.pop();
            pre = cur;
            pathSum -= cur.val;
            path.remove(path.size() - 1);
            cur = null;
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
