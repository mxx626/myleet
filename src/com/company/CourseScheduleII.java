package com.company;
// Topological, BFS< DFS, Graph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    /**
     * There are a total of n courses you have to take, labeled from 0 to n-1.

     Some courses may have prerequisites, for example to take course 0 you have to first
     take course 1, which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, return the ordering
     of courses you should take to finish all courses.

     There may be multiple correct orders, you just need to return one of them. If it is
     impossible to finish all courses, return an empty array.

     Example 1:

     Input: 2, [[1,0]]
     Output: [0,1]
     Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
     course 0. So the correct course order is [0,1] .
     Example 2:

     Input: 4, [[1,0],[2,0],[3,1],[3,2]]
     Output: [0,1,2,3] or [0,2,1,3]
     Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
     courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
     So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
     Note:

     The input prerequisites is a graph represented by a list of edges, not adjacency
     matrices. Read more about how a graph is represented.
     You may assume that there are no duplicate edges in the input prerequisites.
     Hints:

     This problem is equivalent to finding the topological order in a directed graph. If a
     cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
     Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining
     the basic concepts of Topological Sort.
     Topological sort could also be done via BFS.
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        //if (prerequisites==null || prerequisites.length==0) return res;
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i=0; i<numCourses; ++i){
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites){
            int course = edge[0];
            int pre = edge[1];
            adjList.get(pre).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<indegree.length; ++i){
            if (indegree[i]==0)
                q.offer(i);
        }
        int idx=0;
        while (!q.isEmpty()){
            int tmp = q.poll();
            res[idx++]=tmp;
            for (int x : adjList.get(tmp)){
                indegree[x]--;
                if (indegree[x]==0){
                    q.offer(x);
                }
            }
        }
        return idx==numCourses ? res : new int[0];
    }
}
