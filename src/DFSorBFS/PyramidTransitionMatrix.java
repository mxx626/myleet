package DFSorBFS;
// DFS
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.

 For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of
 color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an
 allowed triple.

 We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed
 triples allowed. Each allowed triple is represented as a string of length 3.

 Return true if we can build the pyramid all the way to the top, otherwise false.

 Example 1:
 Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
 Output: true
 Explanation:
 We can stack the pyramid like this:
 A
 / \
 D   E
 / \ / \
 X   Y   Z

 This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.
 Example 2:
 Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
 Output: false
 Explanation:
 We can't stack the pyramid to the top.
 Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
 Note:
 bottom will be a string with length in range [2, 8].
 allowed will have length in range [0, 200].
 Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
 */
public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        for (String word : allowed){
            if (!map.containsKey(word.substring(0,2))){
                map.put(word.substring(0,2), new LinkedList<>());
            }
            map.get(word.substring(0,2)).offer(word.substring(2));
        }
        if (bottom.length()==2) return map.containsKey(bottom);
        return helper(bottom, new StringBuilder(), map, bottom.length()-1);
    }
    public boolean helper(String str, StringBuilder s, Map<String, LinkedList<String>> map, int level){
        if (s.length()==2 && level==2){
            if (map.containsKey(s.toString())) return true;
            return false;
        }
        if (s.length()==level){
            return helper(s.toString(), new StringBuilder(), map, level-1);
        }
        for (int i=0; i<str.length()-1; i++){
            String key = str.substring(i,i+2);
            if (!map.containsKey(key)) return false;
            for (int j=0; j<map.get(key).size(); ++j){
                String tmp = map.get(key).get(j);
                s.append(tmp);
                if (helper(str.substring(i+1), s, map, level)) return true;
                s.deleteCharAt(s.length()-1);
            }
        }
        return false;
    }
}
