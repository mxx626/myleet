package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.
 * Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end),
 * the range of real numbers x such that start <= x < end.
 * A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple
 * booking. Otherwise, return false and do not add the event to the calendar.
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 *
 * Example 1:
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 *
 * Explanation:
 * The first two events can be booked.  The third event can be double booked.
 * The fourth event (5, 15) can't be booked, because it would result in a triple booking.
 * The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
 * The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
 * the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 *
 * Note:
 * The number of calls to MyCalendar.book per test case will be at most 1000.
 * In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9]
 * **/
public class BST_MyCalendarII {
    private TreeMap<Integer, Integer> tree;
    private List<int[]> single;
    public BST_MyCalendarII() {
        tree = new TreeMap<>();
        single = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        tree.put(start, tree.getOrDefault(start, 0)+1);
        tree.put(end, tree.getOrDefault(end, 0)-1);
        int count=0;
        for (Integer i : tree.values()){
            count+=i;
            if (count>2) {
                tree.put(start, tree.get(start) - 1);
                tree.put(end, tree.get(end) + 1);
                if (tree.get(start) == 0) {
                    tree.remove(start);
                }
                return false;
            }
        }
        return true;
    }

    //SOlution 2: much faster!!
    public boolean book1(int start, int end) {
        Integer floorKey = tree.floorKey(start);
        if (floorKey!=null && tree.get(floorKey) > start) return false;
        Integer ceilingKey = tree.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false;

        for (int[] pair : single){
            if (pair[0] >= end || pair[1] <= start) continue;
            else {
                int[] _arr = new int[2];
                _arr[0] = Math.max(pair[0], start);
                _arr[1] = Math.min(pair[1], end);
                tree.put(_arr[0], _arr[1]);
            }
        }
        single.add(new int[]{start, end});
        return true;
    }
}
