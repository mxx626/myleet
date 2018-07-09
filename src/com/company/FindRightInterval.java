package com.company;
// TAG: Binary Search

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        int len = intervals.length;
        int[] res = new int[len];
        Interval[] inter = new Interval[len];
        for (int i=0; i<intervals.length; ++i){
            inter[i] = new Interval(intervals[i].start, i);
        }
        Arrays.sort(inter, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start-o2.start;
            }
        });
        for (int i=0; i<intervals.length; ++i){
            int s=0, e=len-1, idx=-1;
            while (s<=e){
                int m = s+(e-s)/2;
                if (inter[m].start==intervals[i].end) {
                    idx = inter[m].end;
                    break;
                }
                else if (inter[m].start>intervals[i].end){
                    idx = inter[m].end;
                    e=m-1;
                }
                else s=m+1;
            }
            res[i] = idx;
        }
        return res;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
