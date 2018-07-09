package Sort;
// Sort, Greedy, Heap
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        int[] sArr = new int[intervals.length];
        int[] eArr = new int[intervals.length];
        for (int i=0; i<intervals.length; ++i){
            sArr[i]=intervals[i].start;
            eArr[i]=intervals[i].end;
        }
        Arrays.sort(sArr);
        Arrays.sort(eArr);
        int res=0;
        int end=0;
        for (int i=0; i<sArr.length; ++i){
            if(sArr[i]<eArr[end]){
                res++;
            }
            else end++;
        }
        return res;
    }

    public int minMeetingRooms2(Interval[] intervals) {
        if (intervals==null || intervals.length==0) return 0;
        if (intervals.length==1) return 1;
        Arrays.sort(intervals, (a,b)->a.start-b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0].end);
        int count=1;
        for (int i=1; i<intervals.length; ++i){
            if (intervals[i].start<pq.peek()){
                count++;
            }
            else {
                pq.poll();
            }
            pq.offer(intervals[i].end);
        }
        return count;
    }

    public class Interval {
     int start;
     int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
