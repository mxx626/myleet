package Arrays;

import java.util.TreeMap;

public class MyCalendarII {
    /**
     * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will
     * not cause a triple booking.

     Your class will have one method, book(int start, int end). Formally, this represents a booking on the half
     open interval [start, end), the range of real numbers x such that start <= x < end.

     A triple booking happens when three events have some non-empty intersection (ie., there is some time that
     is common to all 3 events.)

     For each call to the method MyCalendar.book, return true if the event can be added to the calendar
     successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.

     Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
     Example 1:
     MyCalendar();
     MyCalendar.book(10, 20); // returns true
     MyCalendar.book(50, 60); // returns true
     MyCalendar.book(10, 40); // returns true
     MyCalendar.book(5, 15); // returns false
     MyCalendar.book(5, 10); // returns true
     MyCalendar.book(25, 55); // returns true
     Explanation:
     The first two events can be booked.  The third event can be double booked.
     The fourth event (5, 15) can't be booked, because it would result in a triple booking.
     The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
     The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
     the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
     Note:

     The number of calls to MyCalendar.book per test case will be at most 1000.
     In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
     */
     //Best;
    class Node{
        int start,end;
        Node left,right;
        boolean overlap;
        public Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    private Node root;
    public MyCalendarII(){
        root = null;
    }
    public boolean book2(int start,int end){
        if(search(root,start,end))return false;
        root = add(root,start,end);
        return true;
    }
    public boolean search(Node root,int start,int end){
        if(start>=end)return false;
        if(root==null)return false;
        if(root.start>=end)return search(root.left,start,end);
        else if(root.end<=start)return search(root.right,start,end);
        else{
            if(root.overlap)return true;
            else{
                if(root.start<=start && end<=root.end)return false;
                return search(root.left,start,root.start) || search(root.right,root.end,end);
            }
        }
    }
    public Node add(Node root,int start,int end){
        if(root==null){
            root = new Node(start,end);
            return root;
        }
        if(root.end<=start)root.right = add(root.right,start,end);
        else if(root.start>=end)root.left = add(root.left,start,end);
        else{
            root.overlap = true;
            int a = Math.min(start,root.start);
            int b = Math.max(start,root.start);
            int c = Math.min(end,root.end);
            int d = Math.max(end,root.end);
            root.start = b;
            root.end = c;
            root.left = add(root.left,a,b);
            root.right = add(root.right,c,d);
        }
        return root;
    }












     /////////////////////////////////////////
    TreeMap<Integer, Integer> map = new TreeMap<>();


    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0)+1);
        map.put(end, map.getOrDefault(end, 0)-1);
        int count=0;
        for (int i : map.values()){
            count += i;
            if (count==3){
                map.put(start, map.get(start)-1);
                map.put(end,map.get(end)+1);
                if (map.get(start)==0){
                    map.remove(start);
                }
                return false;
            }
        }
        return true;
    }
}
