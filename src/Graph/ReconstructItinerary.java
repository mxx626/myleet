package Graph;

import java.util.*;
// Graph, DFS, Eluerian Path
public class ReconstructItinerary {
    /**
     * Given a list of airline tickets represented by pairs of departure and arrival
     * airports [from, to], reconstruct the itinerary in order. All of the tickets
     * belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

     Note:

     If there are multiple valid itineraries, you should return the itinerary that
     has the smallest lexical order when read as a single string. For example, the
     itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     All airports are represented by three capital letters (IATA code).
     You may assume all tickets form at least one valid itinerary.
     Example 1:

     Input: tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
     Example 2:

     Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     Explanation:
     * @param tickets
     * @return
     */
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets==null || tickets.length==0) return res;
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                return o1[1].compareTo(o2[1]);
            }
        });
        Map<String, List<String>> map = new HashMap<>();
        for (String[] str : tickets){
            String org = str[0];
            String des = str[1];
            if (!map.containsKey(org)) map.put(org, new ArrayList<>());
            map.get(org).add(str[1]);
        }
        helper(map, res, "JFK");
        res.add(0, "JFK");
        return res;
    }
    private void helper(Map<String, List<String>> map, List<String> res, String start){
        if (!map.containsKey(start) || map.get(start).size()==0) return;
        while (map.get(start).size()!=0){
            String str = map.get(start).get(0);
            map.get(start).remove(0);
            helper(map, res, str);
            res.add(0, str);
        }
    }
}
