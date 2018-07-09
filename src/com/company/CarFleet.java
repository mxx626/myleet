package com.company;
// Heap
import java.util.Comparator;
import java.util.PriorityQueue;

public class CarFleet {
    /**
     *
     * 853. Car Fleet
     *
     *
     *N cars are going to the same destination along a one lane road.  The destination is target miles away.

     Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles
     towards the target along the road.

     A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper
     at the same speed.

     The distance between these two cars is ignored - they are assumed to have the same position.

     A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a
     single car is also a car fleet.

     If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public int carFleet(int target, int[] position, int[] speed) {
        if (position==null || position.length==0 || speed==null || speed.length==0) return 0;
        int num = position.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[0]-o1[0];
            }
        });
        for (int i=0; i<position.length; ++i){
            pq.offer(new int[]{position[i], speed[i]});
        }
        double time = ((double)(target-pq.peek()[0]))/pq.poll()[1];
        int count =1;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            double t = (double)((target-cur[0]))/cur[1];
            if (t>time){
                time = t;
                count++;
            }
        }
        return count;
    }
}
