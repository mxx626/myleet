package BinarySearch;

import java.util.*;

// TAG: DP, Binary Search, Greedy
public class IsSubsequence {
    /**
     * Given a string s and a string t, check if s is subsequence of t.

     You may assume that there is only lower case English letters in both s and t. t is potentially a
     very long (length ~= 500,000) string, and s is a short string (<=100).

     A subsequence of a string is a new string which is formed from the original string by deleting
     some (can be none) of the characters without disturbing the relative positions of the remaining
     characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

     Example 1:
     s = "abc", t = "ahbgdc"

     Return true.

     Example 2:
     s = "axc", t = "ahbgdc"

     Return false.

     Follow up:
     If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one
     by one to see if T has its subsequence. In this scenario, how would you change your code?

     Credits:
     Special thanks to @pbrother for adding this problem and creating all test cases.
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s==null || s.length()==0) return true;
        if (t==null || s.length()==0) return false;
        int sl = s.length(), tl = t.length();
        int[] dp = new int[tl+1];
        for (int i=0; i<sl; ++i){
            int[] tmp = new int[tl+1];
            for (int j=0; j<tl; ++j){
                if (s.charAt(i)==t.charAt(j)){
                    tmp[j+1]=1;
                }
                tmp[j+1] += tmp[j+1]==1 ? dp[j] : tmp[j];
            }
            dp=tmp;
        }
        return dp[tl]==sl;
    }

    public boolean isSubsequence2(String s, String t) {
        if (s==null || s.length()==0) return true;
        if (t==null || s.length()==0) return false;
        List<Integer>[] map = new LinkedList[26];
        for (int i=0; i<t.length(); ++i){
            char c = t.charAt(i);
            if (map[c-'a']==null){
                map[c-'a']=new LinkedList<>();
            }
            map[c-'a'].add(i);
        }
        int prev=-1;
        for (int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if (map[c-'a']==null) return false;
            else {
                List<Integer> list = map[c-'a'];
                prev = Collections.binarySearch(list, prev);
                if (prev<0) prev=-prev-1;
                if (prev==map[c-'a'].size()) return false;
                prev=map[c-'a'].get(prev)+1;
            }
        }
        return true;
    }

////////////////////////////////////////////////////////////////////////
    public boolean isSubsequence3(String s, String t) {
        if (s==null || s.length()==0) return true;
        if (t==null || s.length()==0) return false;
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i=0; i<t.length(); ++i){
            char c = t.charAt(i);
            if (!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int prev=-1;
        for (int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if (!map.containsKey(c)) return false;
            else{
                ArrayList<Integer> list = map.get(c);
                prev = binarySearch(list, prev, 0, list.size()-1);
                if (prev==-1) return false;
                prev++;
            }
        }
        return true;
    }
    private int binarySearch(ArrayList<Integer> list, int key, int start, int end){
        while (start<=end){
            int mid = start+(end-start)/2;
            if (list.get(mid)<key){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start==list.size() ? -1 : list.get(start);
    }
}
