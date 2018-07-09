package com.company;
// BFS
import java.util.HashSet;

public class MinimumGeneticMutation {
    /**
     * A gene string can be represented by an 8-character long string, with choices
     * from "A", "C", "G", "T".

     Suppose we need to investigate about a mutation (mutation from "start" to "end"),
     where ONE mutation is defined as ONE single character changed in the gene string.

     For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

     Also, there is a given gene "bank", which records all the valid gene mutations.
     A gene must be in the bank to make it a valid gene string.

     Now, given 3 things - start, end, bank, your task is to determine what is the
     minimum number of mutations needed to mutate from "start" to "end". If there
     is no such a mutation, return -1.

     Note:

     Starting point is assumed to be valid, so it might not be included in the bank.
     If multiple mutations are needed, all mutations during in the sequence must be valid.
     You may assume start and end string is not the same.
     Example 1:

     start: "AACCGGTT"
     end:   "AACCGGTA"
     bank: ["AACCGGTA"]

     return: 1
     Example 2:

     start: "AACCGGTT"
     end:   "AAACGGTA"
     bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

     return: 2
     Example 3:

     start: "AAAAACCC"
     end:   "AACCCCCC"
     bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

     return: 3
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        char[] arr = {'A','C','G','T'};
        HashSet<String> set = new HashSet<>();
        for (String b : bank){
            if (b.equals(start)) continue;
            set.add(b);
        }
        if (!set.contains(end)) return -1;
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        set1.add(start);
        set2.add(end);
        int step=0;
        while(!set1.isEmpty() && !set2.isEmpty()){
            ++step;
            if (set1.size()>set2.size()){
                HashSet<String> tmp = set1;
                set1 = set2;
                set2 = tmp;
            }
            HashSet<String> next = new HashSet<>();
            for (String tmp : set1){
                char[] ch = tmp.toCharArray();
                for (int i=0; i<8; ++i){
                    char c = ch[i];
                    for (int j=0; j<4; ++j){
                        if (c==arr[j]) continue;
                        ch[i] = arr[j];
                        String s = new String(ch);
                        if (set2.contains(s)) return step;
                        if (!set.contains(s)) continue;
                        next.add(s);
                        set.remove(s);
                    }
                    ch[i] = c;
                }
            }
            set1 = next;

        }
        return -1;
    }
}
