package com.company;

import java.util.*;

public class BFSorDFS_NetworkDelayTime {
    /**
     * There are N network nodes, labelled 1 to N.
     * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
     * v is the target node, and w is the time it takes for a signal to travel from source to target.
     * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
     * If it is impossible, return -1.
     *
     * Note:
     * N will be in the range [1, 100].
     * K will be in the range [1, N].
     * The length of times will be in the range [1, 6000].
     * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        if (N==1) return 0;
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        int[] visited = new int[N+1];
        int res=0;
        for (int[] time : times){
            if (!map.containsKey(time[0])){
                map.put(time[0], new ArrayList<>());
            }
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }
        HashMap<Integer, Integer> dist = new HashMap<>();
        for (int node=1; node<=N; ++node){
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(K, 0);
        while (true){
            int curNode = -1;
            int curDist = Integer.MAX_VALUE;
            for (int i=1; i<=N; ++i){
                if (visited[i]==0 && dist.get(i)<curDist){
                    curDist=dist.get(i);
                    curNode=i;
                }
            }
            if (curNode < 0) break;
            visited[curNode]=1;
            if (map.containsKey(curNode)){
                for (int[] adj : map.get(curNode)){
                    dist.put(adj[0],
                            Math.min(dist.get(adj[0]), dist.get(curNode)+adj[1]));
                }
            }
        }
        for (int i : dist.values()){
            if (i==Integer.MAX_VALUE) return -1;
            res = Math.max(res, i);
        }
        return res;
    }
}
