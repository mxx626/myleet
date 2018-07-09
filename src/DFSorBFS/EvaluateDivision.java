package DFSorBFS;
// DFS
import java.util.*;

/**
 * 399. Evaluate Division

 Equations are given in the format A / B = k, where A and B are variables represented as strings,
 and k is a real number (floating point number). Given some queries, return the answers. If the
 answer does not exist, return -1.0.

 Example:
 Given a / b = 2.0, b / c = 3.0.
 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 return [6.0, 0.5, -1.0, 1.0, -1.0 ].

 The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string,
 string>> queries , where equations.size() == values.size(), and the values are positive. This
 represents the equations. Return vector<double>.

 According to the example above:

 equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 The input is always valid. You may assume that evaluating the queries will result in no division
 by zero and there is no contradiction.
 */
public class EvaluateDivision {
    class Edge{
        String End;
        double val;
        public Edge(String vertex, double value){
            this.End = vertex;
            this.val = value;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Edge>> map = new HashMap<>();
        double[] res = new double[queries.length];
        for (int i=0; i<equations.length; ++i){
            double val = values[i];
            String e1  = equations[i][0];
            String e2  = equations[i][1];
            if (!map.containsKey(e1)) map.put(e1, new ArrayList<>());
            if (!map.containsKey(e2)) map.put(e2, new ArrayList<>());
            map.get(e1).add(new Edge(e2, val));
            map.get(e2).add(new Edge(e1, 1.0/val));
        }
        int idx = 0;
        for (String[] query : queries){
            Set<String> set = new HashSet<>();
            set.add(query[0]);
            res[idx++] = dfs(map, 1.0, query[0], query[1], set);
        }
        return res;
    }

    private double dfs(Map<String, List<Edge>> map, double product, String start, String end, Set<String> set){
        if (!map.containsKey(start)) return -1.0;
        if (start.equals(end)) return product;
        List<Edge> list = map.get(start);
        for (Edge edge : list){
            if (!set.contains(edge.End)){
                set.add(edge.End);
                double res = dfs(map, product*edge.val, edge.End, end, set);
                if (res!=-1.0) return res;
            }
        }
        return -1.0;
    }
}
