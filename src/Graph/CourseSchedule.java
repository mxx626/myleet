package Graph;
// Topological Sort, DFS, BFS, Graph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    /**
     * There are a total of n courses you have to take, labeled from 0 to n-1.

     Some courses may have prerequisites, for example to take course 0 you have to
     first take course 1, which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, is it
     possible for you to finish all courses?

     Example 1:

     Input: 2, [[1,0]]
     Output: true
     Explanation: There are a total of 2 courses to take.
     To take course 1 you should have finished course 0. So it is possible.
     Example 2:

     Input: 2, [[1,0],[0,1]]
     Output: false
     Explanation: There are a total of 2 courses to take.
     To take course 1 you should have finished course 0, and to take course 0 you should
     also have finished course 1. So it is impossible.
     Note:

     The input prerequisites is a graph represented by a list of edges, not adjacency
     matrices. Read more about how a graph is represented.
     You may assume that there are no duplicate edges in the input prerequisites.
     Hints:

     This problem is equivalent to finding if a cycle exists in a directed graph.
     If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
     Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
     explaining the basic concepts of Topological Sort.
     Topological sort could also be done via BFS.
     * @param numCourses
     * @param prerequisites
     * @return
     */
    // Topological + DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0) return true;
        List<List<Integer>> next = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i=0; i<numCourses; ++i) next.add(new ArrayList<>());
        for (int i=0; i<prerequisites.length; ++i){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            next.get(pre).add(course);
        }
        int[] visit = new int[numCourses];
        for (int i=0; i<numCourses; ++i){
            if (!helper(i, visit, next)){
                return false;
            }
        }
        return true;
    }
    private boolean helper(int cur, int[] visit, List<List<Integer>> next){
        if (visit[cur]==1) return false;
        if (visit[cur]==2) return true;
        visit[cur]=1;
        for (int i : next.get(cur)){
            if (!helper(i, visit, next)){
                return false;
            }
        }
        visit[cur]=2;
        return true;
    }


    // Topological + BFS
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0) return true;
        List<List<Integer>> next = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i=0; i<numCourses; ++i) next.add(new ArrayList<>());
        for (int i=0; i<prerequisites.length; ++i){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            next.get(pre).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] visit = new int[numCourses];
        for (int i=0; i<numCourses; ++i) {
            if (indegree[i]==0)
                q.offer(i);
        }
        int finishCourse=0;
        while (!q.isEmpty()){
            int tmp = q.poll();
            finishCourse++;
            for (int x : next.get(tmp)){
                indegree[x]--;
                if (indegree[x]==0)
                    q.offer(x);
            }
        }
        return finishCourse==numCourses;
    }
}
