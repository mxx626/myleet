package com.company;

import java.util.*;

/**
 *  Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined
 *  as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is
 *  the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 *  Examples :
 *  Input:
 *            5
 *          /  \
 *         2   -3
 *  return [2, -3, 4], since all the values happen only once, return all of them in any order.
 *
 *  Examples 2
 *  Input:
 *            5
 *          /  \
 *         2   -5
 *  return [2], since 2 happens twice, however -5 only occur once.
 *  Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 * **/
public class MostFrequentSubtreeSum {
    class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int x) {
            this.val=x;
        }
    }
    private int maxFreq=0;
    private int count=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(map, root);
        int[] res = new int[count];
        int i=0;
        for (Integer key : map.keySet()){
            if (map.get(key)==maxFreq){
                res[i++]=key;
            }
        }
        return res;
    }

    public int helper (Map<Integer, Integer> map, TreeNode root){
        if (root==null) return 0;
        int left = helper(map, root.left);
        int right = helper(map, root.right);
        int sum = root.val+left+right;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        if (map.get(sum) > maxFreq){
            maxFreq = map.get(sum);
            count=1;
        }
        else if (map.get(sum)==maxFreq){
            count++;
        }
        return sum;
    }
}
