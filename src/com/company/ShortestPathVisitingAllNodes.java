package com.company;
// DP, BFS

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    /**
     * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.

     graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.

     Return the length of the shortest path that visits every node. You may start and stop at any node,
     you may revisit nodes multiple times, and you may reuse edges.
     * @param graph
     * @return
     */
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1<<n];
        Queue<Pair> queue = new LinkedList<>();
        for (int i=0; i<graph.length; ++i){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            queue.offer(new Pair(i, 1<<i));
            dp[i][1<<i] = 0;
        }
        int finalState = (1<<n)-1;
        while (!queue.isEmpty()){
            Pair cur = queue.poll();
            int  org = cur.start;
            int  sta = cur.state;
            int dist = dp[org][sta];
            if (sta == finalState) return dist;
            for (int i=0; i<graph[org].length; ++i){
                int next = graph[org][i];
                int nextState = sta | (1<<next);
                if (dist+1 < dp[next][nextState]){
                    dp[next][nextState]=dist+1;
                    queue.offer(new Pair(next, nextState));
                }
            }
        }
        return 0;

    }
    class Pair {
        int start = 0;
        int state = 0;
        public Pair(int start, int state){
            this.start = start;
            this.state = state;
        }
    }
}
