package com.company;
// Dijsktra

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 743. Network Delay Time

 There are N network nodes, labelled 1 to N.

 Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the
 source node, v is the target node, and w is the time it takes for a signal to travel from
 source to target.

 Now, we send a signal from a certain node K. How long will it take for all nodes to receive
 the signal? If it is impossible, return -1.

 Note:
 N will be in the range [1, 100].
 K will be in the range [1, N].
 The length of times will be in the range [1, 6000].
 All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times==null || times.length==0) return 0;
        int[][] grid = new int[N+1][N+1];
        for (int[] arr : grid) Arrays.fill(arr, Integer.MAX_VALUE);
        for (int[] time : times){
            grid[time[0]][time[1]]=time[2];
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return dist[o1]-dist[o2];
            }
        });
        dist[K]=0;
        queue.offer(K);
        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            for (int i=1; i<=N; ++i){
                if (grid[cur][i]!=Integer.MAX_VALUE && dist[i]>dist[cur]+grid[cur][i]){
                    dist[i] = dist[cur]+grid[cur][i];
                    queue.offer(i);
                }
            }
        }
        int count = 0;
        for (int i=1; i<N+1; ++i){
            if (dist[i]==Integer.MAX_VALUE) return -1;
            count = Math.max(count, dist[i]);
        }
        return count;
    }
}
