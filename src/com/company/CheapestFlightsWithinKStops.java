package com.company;
// BFS, Djisktra

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops

 There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.

 Now given all the cities and fights, together with starting city src and the destination dst, your task
 is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

 Example 1:
 Input:
 n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 src = 0, dst = 2, k = 1
 Output: 200
 Explanation:
 The graph looks like this:


 The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 Example 2:
 Input:
 n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 src = 0, dst = 2, k = 0
 Output: 500
 Explanation:
 The graph looks like this:


 The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 Note:

 The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 The size of flights will be in range [0, n * (n - 1) / 2].
 The format of each flight will be (src, dst, price).
 The price of each flight will be in the range [1, 10000].
 k is in the range of [0, n - 1].
 There will not be any duplicated flights or self cycles.
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] grid = new int[n][n];
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        for (int[] fly : flights){
            grid[fly[0]][fly[1]]=fly[2];
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        price[src]=0;
        int step =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            if (step==K+1) break;
            step++;
            for (int i=0; i<size; ++i){
                Integer cur = queue.poll();
                for (int j=0; j<n; ++j){
                    if (step==K+1 && j!=dst) continue;
                    if (grid[cur][j]!=0 && price[j]>price[cur]+grid[cur][j]){
                        price[j]=price[cur]+grid[cur][j];
                        queue.offer(j);
                    }
                }
            }
        }
        return price[dst]==Integer.MAX_VALUE ? -1 : price[dst];
    }

    private int res=Integer.MAX_VALUE;
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, List<int[]>> flight = new HashMap<>();
        for (int[] f : flights){
            if (!flight.containsKey(f[0])){
                flight.put(f[0], new ArrayList<>());
            }
            flight.get(f[0]).add(new int[]{f[1], f[2]});
        }
        DFS(src, dst, K, 0, flight, new int[n]);
        return res==Integer.MAX_VALUE ? -1 : res;
    }
    private void DFS (int src, int dst, int K, int price, HashMap<Integer, List<int[]>> flight, int[] visited){
        if (src == dst){
            res=Math.min(price, res);
        }
        else if (K>=0 && price < res){
            List<int[]> nextStop = flight.get(src);
            if (nextStop==null) return;
            for (int [] f : nextStop){
                if (f!=null && visited[f[0]]==0){
                    int next = f[0];
                    int trip = f[1];
                    visited[f[0]]=1;
                    DFS(next, dst, K-1, price+trip, flight, visited);
                    visited[f[0]]=0;
                }
            }
        }
    }

}
