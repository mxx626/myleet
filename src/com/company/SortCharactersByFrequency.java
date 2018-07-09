package com.company;
// TAG: HashTable, Heap
import java.util.ArrayList;
import java.util.List;

public class SortCharactersByFrequency {
    /**
     *Given a string, sort it in decreasing order based on the frequency of characters.

     Example 1:

     Input:
     "tree"

     Output:
     "eert"

     Explanation:
     'e' appears twice while 'r' and 't' both appear once.
     So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     Example 2:

     Input:
     "cccaaa"

     Output:
     "cccaaa"

     Explanation:
     Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
     Note that "cacaca" is incorrect, as the same characters must be together.
     Example 3:

     Input:
     "Aabb"

     Output:
     "bbAa"

     Explanation:
     "bbaA" is also a valid answer, but "Aabb" is incorrect.
     Note that 'A' and 'a' are treated as two different characters.
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()){
            count[c]++;
        }
        List<Character>[] list = new List[s.length()+1];
        for (int i=0; i<count.length; ++i){
            if (count[i]!=0){
                if (list[count[i]]==null){
                    list[count[i]] = new ArrayList<>();
                }
                list[count[i]].add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=list.length-1; i>=0; --i){
            if (list[i]!=null){
                for (char c : list[i]){
                    int k=i;
                    while (k-->0){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    public String frequencySort2(String s) {
        int[] count = new int[256];
        char[] res = new char[s.length()];
        int start=0;
        for (char c : s.toCharArray()){
            count[c]++;
        }
        for (char c : s.toCharArray()){
            int max=0;
            int idx=0;
            for (int i=0; i<count.length; ++i){
                if (count[i]>max){
                    max=count[i];
                    idx=i;
                }
            }
            count[idx]=0;
            while (max-->0){
                res[start++]=(char)idx;
            }
        }
        return new String(res);
    }
}
