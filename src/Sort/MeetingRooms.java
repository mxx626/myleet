package Sort;
// Sort

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    //QuickSort II
    public boolean canAttendMeetings3(Interval[] intervals) {
        // Arrays.sort(intervals, (a, b) -> a.start - b.start);

        quickSort1(intervals, 0, intervals.length - 1);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start)
                return false;
        }
        return true;

    }
    private void quickSort1(Interval[] intervals, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int middle = i + (j - i) / 2;
            int pivot = intervals[i + (j - i) / 2].start;
            while (i <= j) {
                while (i <= j && intervals[i].start < pivot)
                    i++;
                while (i <= j && intervals[j].start > pivot)
                    j--;
                if (i <= j) {
                    Interval tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                    i++;
                    j--;
                }
            }

            quickSort1(intervals, left, j);
            quickSort1(intervals, i, right);
        }
    }


    // QuickSort
    public boolean canAttendMeetings1(Interval[] intervals) {
        if (intervals==null || intervals.length<=1) return true;
        quickSort(intervals, 0, intervals.length-1);
        for (int i=1; i<intervals.length; ++i){
            if (intervals[i].start<intervals[i-1].end)
                return false;
        }
        return true;
    }

    private void quickSort(Interval[] intervals, int s, int e){
        if (s<e){
            int pi = partition(intervals, s, e);
            quickSort(intervals, s, pi-1);
            quickSort(intervals, pi+1, e);
        }
    }

    private int partition(Interval[] intervals, int s, int e){
        int i=s-1;
        int pivot = intervals[e].start;
        for (int j=s; j<e; ++j){
            if (intervals[j].start<=pivot){
                i++;
                Interval tmp = intervals[j];
                intervals[j] = intervals[i];
                intervals[i] = tmp;
            }
        }
        Interval tmp1  = intervals[i+1];
        intervals[i+1] = intervals[e];
        intervals[e]   = tmp1;
        return i+1;
    }


    // SOrt
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals==null || intervals.length<=1) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start-o2.start;
            }
        });
        for (int i=1; i<intervals.length; ++i){
            if (intervals[i].start<intervals[i-1].end)
                return false;
        }
        return true;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

}
