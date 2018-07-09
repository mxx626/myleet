package DFSorBFS;
// BFS, Topological
import java.util.*;

/**
 * 269. Alien Dictionary

 There is a new alien language which uses the latin alphabet. However, the order
 among letters are unknown to you. You receive a list of non-empty words from the
 dictionary, where words are sorted lexicographically by the rules of this new
 language. Derive the order of letters in this language.

 Example 1:

 Input:
 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]

 Output: "wertf"
 Example 2:

 Input:
 [
 "z",
 "x"
 ]

 Output: "zx"
 Example 3:

 Input:
 [
 "z",
 "x",
 "z"
 ]

 Output: ""

 Explanation: The order is invalid, so return "".
 Note:

 You may assume all letters are in lowercase.
 You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        for (int i=0; i<words.length; ++i){
            for (char c : words[i].toCharArray()){
                if (indegree[c-'a']<0) indegree[c-'a']=0;
            }
            if (i>0){
                String cur = words[i-1];
                String next = words[i];
                int length = Math.min(cur.length(), next.length());
                for (int j=0; j<length; ++j){
                    char c1 = cur.charAt(j);
                    char c2 = next.charAt(j);
                    if (c1!=c2){
                        if (!map.containsKey(c1)) map.put(c1, new HashSet<>());
                        if (map.get(c1).add(c2)){
                            indegree[c2-'a']++;
                        }
                        break;
                    }
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; ++i){
            if (indegree[i]==0){
                queue.offer((char)(i+'a'));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            char cur = queue.poll();
            sb.append(cur);
            if (map.get(cur)==null) continue;
            for (char next : map.get(cur)){
                indegree[next-'a']--;
                if (indegree[next-'a']==0) queue.offer(next);
            }
        }
        int count = 0;
        for (int i=0; i<indegree.length; ++i){
            if (indegree[i]>=0) count++;
        }
        if (sb.length()!=count) return "";
        return sb.toString();
    }
}
