package com.company;

import java.util.*;

// BFS, DFS
public class LoudandRich {
    /**
     * In a group of N people (labelled 0, 1, 2, ..., N-1), each person has different
     * amounts of money, and different levels of quietness.

     For convenience, we'll call the person with label x, simply "person x".

     We'll say that richer[i] = [x, y] if person x definitely has more money than person
     y.  Note that richer may only be a subset of valid observations.

     Also, we'll say quiet[x] = q if person x has quietness q.

     Now, return answer, where answer[x] = y if y is the least quiet person (that is,
     the person y with the smallest value of quiet[y]), among all people who definitely
     have equal to or more money than person x.



     Example 1:

     Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
     Output: [5,5,2,5,4,5,6,7]
     Explanation:
     answer[0] = 5.
     Person 5 has more money than 3, which has more money than 1, which has more money than 0.
     The only person who is quieter (has lower quiet[x]) is person 7, but
     it isn't clear if they have more money than person 0.

     answer[7] = 7.
     Among all people that definitely have equal to or more money than person 7
     (which could be persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x])
     is person 7.

     The other answers can be filled out with similar reasoning.
     Note:

     1 <= quiet.length = N <= 500
     0 <= quiet[i] < N, all quiet[i] are different.
     0 <= richer.length <= N * (N-1) / 2
     0 <= richer[i][j] < N
     richer[i][0] != richer[i][1]
     richer[i]'s are all different.
     The observations in richer are all logically consistent.
     * @param richer
     * @param quiet
     * @return
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int len = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<len; ++i) graph.add(new ArrayList<>());
        int[] ans = new int[len];
        for (int[] pair : richer){
            int less = pair[1];
            int more = pair[0];
            graph.get(less).add(more);
        }
        for (int i=0; i<quiet.length; ++i){
            ans[i] = i;
            if (quiet[i]==0) continue;
            int[] visit = new int[len];
            ans[i] = helper(graph, i, quiet, visit);
        }
        return ans;
    }
    private int helper(List<List<Integer>> graph, int i, int[] quiet, int[] visit){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i]=1;
        int res = quiet[i];
        int idx = i;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if (quiet[cur]<res){
                res = quiet[cur];
                idx = cur;
            }
            if (graph.get(cur).size()==0) continue;
            for (int next : graph.get(cur)){
                if (visit[next]==0){
                    queue.offer(next);
                    visit[next]=1;
                }
            }
        }
        return idx;
    }
    // DFS
    public int[] loudAndRich2(int[][] richer, int[] quiet) {
        int len = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<len; ++i) graph.add(new ArrayList<>());
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        for (int[] pair : richer){
            int less = pair[1];
            int more = pair[0];
            graph.get(less).add(more);
        }
        for (int i=0; i<quiet.length; ++i){
            dfs(graph, i, quiet, ans);
        }
        return ans;
    }
    private int dfs(List<List<Integer>> graph, int i, int[] quiet, int[] ans){
        if (ans[i]==-1){
            ans[i]=i;
            for (int next : graph.get(i)){
                int cand = dfs(graph, next, quiet, ans);
                if (quiet[cand]<quiet[ans[i]]){
                    ans[i]=cand;
                }
            }
        }
        return ans[i];
    }
}
