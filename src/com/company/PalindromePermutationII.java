package com.company;
// Backtracking
import java.util.ArrayList;
import java.util.List;

public class PalindromePermutationII {
    /**
     * Given a string s, return all the palindromic permutations (without duplicates)
     * of it. Return an empty list if no palindromic permutation could be form.
     * @param s
     * @return
     */
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int len = isValid(s);
        if (len!=s.length() && len!=s.length()-1) return res;
        int[] count = new int[256];
        for (char c : s.toCharArray()) count[c]++;
        String single = "";
        List<Character> list = new ArrayList<>();
        for (int i=0; i<count.length; ++i){
            if (count[i]%2==1){
                single = new String(((char)i)+"");
                count[i]--;
            }
            for (int j=0; j<count[i]/2; ++j){
                list.add((char)i);
            }
        }
        boolean[] visit = new boolean[list.size()];
        helper(res, list, single, visit, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, List<Character> list, String single, boolean[] visit, StringBuilder sb){
        if (sb.length()==list.size()){
            res.add(sb.toString()+single+sb.reverse().toString());
            sb.reverse();
            return;
        }
        for (int i=0; i<list.size(); ++i){
            if ((i>0 && list.get(i)==list.get(i-1) && !visit[i-1])) continue;
            if (!visit[i]){
                sb.append(list.get(i));
                visit[i]=true;
                helper(res, list, single, visit, sb);
                visit[i]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    private int isValid(String s){
        int[] count = new int[256];
        for (char c : s.toCharArray()){
            count[c]++;
        }
        int ret=0;
        for (int i : count){
            if (i%2==0) ret += i;
            else ret += i-1;
        }
        return ret;
    }
}
