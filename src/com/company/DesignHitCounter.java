package com.company;
// Queue, Design
import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.

 Each function accepts a timestamp parameter (in seconds granularity) and you may assume
 that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

 It is possible that several hits arrive roughly at the same time.
 */
public class DesignHitCounter {
    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public DesignHitCounter() {
        queue = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (queue.peek()!=null && (timestamp - queue.peek()) >= 300){
            queue.poll();
        }
        return queue.size();
    }
}
