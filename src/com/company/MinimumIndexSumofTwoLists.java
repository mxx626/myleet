package com.company;
// HashTable
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. Minimum Index Sum of Two Lists

 Suppose Andy and Doris want to choose a restaurant for dinner, and they both have
 a list of favorite restaurants represented by strings.

 You need to help them find out their common interest with the least list index sum.
 If there is a choice tie between answers, output all of them with no order requirement.
 ou could assume there always exists an answer.

 Example 1:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 Output: ["Shogun"]
 Explanation: The only restaurant they both like is "Shogun".
 Example 2:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["KFC", "Shogun", "Burger King"]
 Output: ["Shogun"]
 Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 Note:
 The length of both lists will be in the range of [1, 1000].
 The length of strings in both lists will be in the range of [1, 30].
 The index is starting from 0 to the list length minus 1.
 No duplicates in both lists.
 */
public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<list1.length; ++i){
            map.put(list1[i], map.getOrDefault(list1[i], 0)+i);
        }
        for (int j=0; j<list2.length; ++j){
            if (map.containsKey(list2[j])){
                map.put(list2[j], (map.get(list2[j])+j)*(-2)-1);
            }
            else map.put(list2[j], map.getOrDefault(list2[j], 0)+j);
        }
        //System.out.println(map);
        int res = Integer.MIN_VALUE;
        for (String key : map.keySet()){
            int val = map.get(key);
            if (val<0){
                if (val>res){
                    res = val;
                    ret = new ArrayList<>();
                    ret.add(key);
                }
                else if (val==res){
                    ret.add(key);
                }
            }
        }
        String[] arr = ret.toArray(new String[ret.size()]);
        return arr;
    }
}
