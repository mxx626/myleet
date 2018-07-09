package Greedy;
// Greedy, sort
import java.util.Comparator;
import java.util.Comparator;
import java.util.Arrays;
public class Non_overlappingIntervals {

    //Sort the start
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals==null || intervals.length<=1) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start-o2.start;
            }
        });
        int end = intervals[0].end;
        int count = 1;
        for (int i=1; i<intervals.length; ++i){
            if (intervals[i].start<end){
                end = Math.min(end, intervals[i].end);
            }
            else {
                count++;
                end = intervals[i].end;
            }
        }
        return intervals.length-count;
    }

    //Sort the end

    public int eraseOverlapIntervals2(Interval[] intervals) {
        if (intervals==null || intervals.length<=1) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.end-o2.end;
            }
        });
        int end = intervals[0].end;
        int count = 0;
        for (int i=1; i<intervals.length; ++i){
            if (intervals[i].start<end){
                count++;
            }
            else {
                end = intervals[i].end;
            }
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
