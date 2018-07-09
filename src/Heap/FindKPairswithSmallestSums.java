package Heap;
// Heap
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {
    /**
     * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

     Define a pair (u,v) which consists of one element from the first array and one element from the second array.

     Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

     Example 1:
     Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

     Return: [1,2],[1,4],[1,6]

     The first 3 pairs are returned from the sequence:
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     Example 2:
     Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

     Return: [1,1],[1,1]

     The first 2 pairs are returned from the sequence:
     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     Example 3:
     Given nums1 = [1,2], nums2 = [3],  k = 3

     Return: [1,3],[2,3]

     All possible pairs are returned from the sequence:
     [1,3],[2,3]
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length, l2 = nums2.length;
        int total = k<l1*l2 ? k : l1*l2;
        List<int[]> res = new ArrayList<>();
        if (l1*l2==0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return (o1[0]+o1[1])-(o2[0]+o2[1]);
            }
        });
        for (int i=0; i<nums1.length; ++i){
            for (int j=0; j<nums2.length; ++j){
                pq.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        for (int i=0; i<total; ++i){
            res.add(pq.poll());
        }
        return res;
    }

    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length, l2 = nums2.length;
        int total = k<l1*l2 ? k : l1*l2;
        List<int[]> res = new ArrayList<>();
        if (l1*l2==0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return (o1[0]+o1[1])-(o2[0]+o2[1]);
            }
        });
        for (int i=0; i<nums1.length && i<total; ++i){
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (total-->0){
            int[] tmp = pq.poll();
            res.add(new int[]{tmp[0], tmp[1]});
            if (tmp[2]==nums2.length-1) continue;
            pq.offer(new int[]{tmp[0], nums2[tmp[2]+1], tmp[2]+1});
        }
        return res;
    }
}
