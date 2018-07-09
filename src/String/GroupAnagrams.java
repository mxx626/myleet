package String;
// TAG: String, HashTable

import java.util.*;

public class GroupAnagrams {
    /**
     * Given an array of strings, group anagrams together.

     For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     Return:

     [
     ["ate", "eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     Note: All inputs will be in lower-case.


     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            String key = new String(generateKey(str));
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            List<String> list = map.get(key);
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<>(map.values());

        return res;
    }

    private char[] generateKey(String str){
        char[] key = new char[26];
        for (int i=0; i<str.length(); ++i){
            key[str.charAt(i)-'a']++;
        }
        return key;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
