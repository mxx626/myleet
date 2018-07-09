package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
    /**
     * Given a string, we can "shift" each of its letter to its successive letter,
     * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

     "abc" -> "bcd" -> ... -> "xyz"
     Given a list of strings which contains only lowercase alphabets, group all strings
     that belong to the same shifting sequence.

     For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
     A solution is:

     [
     ["abc","bcd","xyz"],
     ["az","ba"],
     ["acef"],
     ["a","z"]
     ]
     * @param strings
     * @return
     */
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String st : strings){
            String key = getKey(st);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(st);
        }

        return new ArrayList<>(map.values());
    }
    private String getKey(String str){
        StringBuilder sb = new StringBuilder("-");
        char[] ch = str.toCharArray();
        for (int i=1; i<ch.length; ++i){
            int diff = (ch[i]-ch[i-1]+26)%26;
            sb.append(diff);
        }
        return sb.toString();
    }
}
