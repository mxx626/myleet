package DFSorBFS;
// DFS, BFS
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NestedListWeightSum {
    /**
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

     Each element is either an integer, or a list -- whose elements may also be integers or other lists.

     Example 1:
     Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

     Example 2:
     Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)


     * @param nestedList
     * @return
     */
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger cur : nestedList){
            sum += helper(cur, 1);
        }
        return sum;
    }
    private int helper(NestedInteger cur, int depth){
        int sum=0;
        if (cur.isInteger()){
            sum += cur.getInteger()*depth;
        }
        else{
            for (NestedInteger next : cur.getList()){
                sum+=helper(next, depth+1);
            }
        }
        return sum;
    }

    public int depthSum2(List<NestedInteger> nestedList) {
        int sum = 0;
        int level=1;
        Queue<NestedInteger> q = new LinkedList<>(nestedList);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; ++i){
                NestedInteger cur = q.poll();
                if (cur.isInteger()){
                    sum += cur.getInteger()*level;
                }
                else {
                    for (NestedInteger next : cur.getList()){
                        q.offer(next);
                    }
                }
            }
            level++;
        }
        return sum;
    }
}
