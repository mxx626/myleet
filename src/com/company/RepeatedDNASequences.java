package com.company;
// TAG: HashTable, BitManipulation
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RepeatedDNASequences {
    /**
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
     * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify
     * repeated sequences within the DNA.

     Write a function to find all the 10-letter-long sequences (substrings) that
     occur more than once in a DNA molecule.

     For example,

     Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

     Return:
     ["AAAAACCCCC", "CCCCCAAAAA"].

     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> res = new LinkedList<>();
        if (s.length()<=10) return res;
        char[] map = new char[128];
        map['A']=0;
        map['C']=1;
        map['T']=3;
        map['G']=2;
        char[] sc = s.toCharArray();
        int mask = 0xfffff;
        int val=0;
        for (int i=0; i<9; ++i){
            val = (val<<2) | (map[sc[i]]);
        }
        byte[] count = new byte[1<<20];
        for (int i=9; i<sc.length; ++i){
            val = ((val<<2)&mask) | (map[sc[i]]);
            //      System.out.println(count[val]);
            if (count[val]==1) {
                res.add(s.substring(i-9, i+1));
            }
            if (count[val]<2){
                count[val]++;
            }
        }
        return res;
    }
    //mine
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> list = new HashSet<>();
        if (s.length()<=10) return new LinkedList(list);
        int start=0, end=10;
        while (end<=s.length()){
            String str = s.substring(start++, end++);
            if (!set.add(str)){
                list.add(str);
            }
        }
        return new LinkedList(list);
    }
}
