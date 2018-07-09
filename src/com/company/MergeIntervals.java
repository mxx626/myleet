package com.company;
// TAG: Arrays, Sort
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 *    S      E -> E           S      E -> E   // if is at the last interval, it will not add to the res, so we need to
 *     |_____|                 |_____|           add the last interval at the end of the function.
 *         |______|                |______|
 *
 * **/
public class MergeIntervals {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals==null || intervals.size()<=1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals){
            if (interval.start<=end){
                end=Math.max(end, interval.end);
            }
            else {
                res.add(new Interval(start, end));
                start=interval.start;
                end=interval.end;
            }
        }
        res.add(new Interval(start,end));
        return res;
    }

    public List<Interval> merge2(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start-o2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        for (Interval in : intervals){
            if (prev==null || in.start>prev.end){
                res.add(in);
                prev=in;
            }
            else if (in.end>prev.end){
                prev.end=in.end;
            }
        }
        return res;
    }
}
