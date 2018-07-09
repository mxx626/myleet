package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n==0) return tasks.length;
        int[] count = new int[26];
        for (char c : tasks) count[c-'A']++;
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int i : count) if (i>0) queue.offer(i);
        int time = 0;
        while(!queue.isEmpty()){
            int i = 0;
            List<Integer> tmp = new ArrayList<>();
            while(i<=n){
                if (!queue.isEmpty()){
                    int cur = queue.poll();
                    if (cur>1) tmp.add(cur-1);
                }
                time++;
                if (queue.isEmpty() && tmp.size()==0) break;
                i++;
            }
            for (int x : tmp) queue.offer(x);
        }
        return time;
    }


    public int leastInterval2(char[] tasks, int n) {
        if (n==0) return tasks.length;
        int[] count = new int[26];
        for (char c : tasks) count[c-'A']++;
        int max = 0, maxCount=0;
        for (int i : count){
            if (i>max){
                max=i;
                maxCount=1;
            }
            else if(i==max) maxCount++;
        }
        int partCount = max-1;
        int partLength = n-(maxCount-1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length-max*maxCount;
        int idle = Math.max(0, emptySlots - availableTasks);
        return tasks.length+idle;
    }


}
