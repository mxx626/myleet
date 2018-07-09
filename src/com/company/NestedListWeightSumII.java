package com.company;
// DFS, BFS
import DFSorBFS.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NestedListWeightSumII {
    private int max = 1;

    /**
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

     Each element is either an integer, or a list -- whose elements may also be integers or other lists.

     Different from the previous question where weight is increasing from root to leaf, now the weight is
     defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have
     the largest weight.

     Example 1:
     Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

     Example 2:
     Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
     * @param nestedList
     * @return
     */

    //DFS
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Stack<int[]> stack = new Stack<>();
        int level=1;
        for (NestedInteger node : nestedList){
            helper(node, stack, level);
        }
        int sum = 0;
        max++;
        while(!stack.isEmpty()){
            sum += stack.peek()[0]*(max-stack.pop()[1]);
        }
        return sum;
    }
    private void helper(NestedInteger node, Stack<int[]> stack, int level){
        if (level>max) max=level;
        if (node.isInteger()){
            stack.push(new int[]{node.getInteger(), level});
        }
        else{
            level++;
            for (NestedInteger next : node.getList()){
                helper(next, stack, level);
            }
        }
    }

    //BFS
    public int depthSumInverse2(List<NestedInteger> nestedList) {
        Stack<int[]> stack = new Stack<>();
        int level=1;
        Queue<NestedInteger> q = new LinkedList<>(nestedList);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; ++i){
                NestedInteger cur = q.poll();
                if (cur.isInteger()){
                    stack.push(new int[]{cur.getInteger(), level});
                }
                else{
                    for (NestedInteger next : cur.getList()){
                        q.offer(next);
                    }
                }
            }
            level++;
        }
        int sum = 0;
        int x = level;
        while (!stack.isEmpty()){
            sum += stack.peek()[0]*(x-stack.pop()[1]);
        }
        return sum;
    }
}
