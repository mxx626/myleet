package Heap;
// Heap, Greedy
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 759. Employee Free Time

 We are given a list schedule of employees, which represents the working time for each employee.

 Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

 Return the list of finite intervals representing common, positive-length free time for all employees,
 also in sorted order.

 Example 1:
 Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 Output: [[3,4]]
 Explanation:
 There are a total of three employees, and all common
 free time intervals would be [-inf, 1], [3, 4], [10, inf].
 We discard any intervals that contain inf as they aren't finite.
 Example 2:
 Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 Output: [[5,6],[7,9]]
 (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals,
 not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and
 schedule[0][0][0] is not defined.)

 Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

 Note:

 schedule and schedule[i] are lists with lengths in range [1, 50].
 0 <= schedule[i].start < schedule[i].end <= 10^8.
 */
public class EmployeeFreeTime {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            List<Interval> res = new ArrayList<>();
            PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>(){
                @Override
                public int compare(Interval o1, Interval o2){
                    return o1.start-o2.start;
                }
            });
            for (List<Interval> list : schedule){
                for (Interval iter : list){
                    queue.offer(iter);
                }
            }
            int endMax = queue.poll().end;
            while (!queue.isEmpty()){
                Interval cur = queue.poll();
                if (cur.start>endMax) res.add(new Interval(endMax, cur.start));
                endMax = Math.max(endMax, cur.end);
            }
            return res;
        }
}
