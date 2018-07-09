package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PyramidTransitionMatrix {
    /**
     *  We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.

     For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of
     color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an allowed triple.

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

     * **/
    private List<String> res;
    HashMap<String, List<String>> map;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        map =new HashMap<>();
        for (String string : allowed){
            if (!map.containsKey(string.substring(0,2))){
                map.put(string.substring(0,2), new ArrayList<>());
            }
            map.get(string.substring(0,2)).add(string.substring(2));
        }
        return DFS(bottom);
    }
    private boolean DFS(String bottom){
        if (bottom.length()==1) return true;
        for (int i=0; i<bottom.length()-1; ++i){
            if (!map.containsKey(bottom.substring(i, i+2))) return false;
        }
        res = new ArrayList<>();
        contructBottom(0, bottom, new StringBuilder());
        for (String newbottom : res){
            if (DFS(newbottom)) return true;
        }
        return  false;
    }
    private void contructBottom (int idx, String bottom, StringBuilder sb){
        if (idx == bottom.length()-1){
            res.add(new String(sb));
            return;
        }
        for (String str : map.get(bottom.substring(idx, idx+2))){
            sb.append(str);
            contructBottom(idx+1, bottom, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
