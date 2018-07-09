package com.company;
// HashTable
import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs

 Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of
 points (i, j, k) such that the distance between i and j equals the distance between i
 and k (the order of the tuple matters).

 Find the number of boomerangs. You may assume that n will be at most 500 and coordinates
 of points are all in the range [-10000, 10000] (inclusive).

 Example:
 Input:
 [[0,0],[1,0],[2,0]]

 Output:
 2

 Explanation:
 The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int res=0;
        for(int i=0; i<points.length; ++i){
            for (int j=0; j<points.length; ++j){
                if (i==j) continue;
                int dist = valid(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0)+1);
            }
            for (Integer val : map.values()){
                res += val*(val-1);
            }
            map.clear();
        }
        return res;
    }
    private int valid(int[] i, int[] j){
        return (j[0]-i[0])*(j[0]-i[0])+(j[1]-i[1])*(j[1]-i[1]);
    }
}
