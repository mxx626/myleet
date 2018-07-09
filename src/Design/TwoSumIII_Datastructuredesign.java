package Design;
// Design
import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

public class TwoSumIII_Datastructuredesign {
    Map<Integer, Integer> map = new HashMap<>();
    int min;
    int max;
    /** Initialize your data structure here. */
    /**
     *Design and implement a TwoSum class. It should support the following operations: add and find.

     add - Add the number to an internal data structure.
     find - Find if there exists any pair of numbers which sum is equal to the value.
     */
    public TwoSumIII_Datastructuredesign() {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        min = Math.min(number, min);
        max = Math.max(number, max);
        map.put(number, map.getOrDefault(number, 0)+1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (value<2*min || value>2*max) return false;
        for (int key : map.keySet()){
            int num = value-key;
            if (num!=key && map.containsKey(num)) return true;
            else if (num==key && map.get(key)>=2) return true;
        }
        return false;
    }
}
